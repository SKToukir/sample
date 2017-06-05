package toukir.best.com.livecricscore;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    JSONArray jsonArray;
    JSONObject jsonObject;
    ListView teamList;
    CustomAdapter adapter;
    ProgressBar progressBar;
    String teamOne, teamTwo;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/contrast.ttf");

        txtMsg = (TextView) findViewById(R.id.textView);
        txtMsg.setTypeface(customFont);
        teamList = (ListView) findViewById(R.id.teamList);

        //mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        if (isNetworkConnected()) {


            try{
                new BackgroundTask().execute();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else {
            new BackgroundTask().onPostExecute(readFromFile());
            progressBar.setVisibility(View.GONE);
        }
    }

    class BackgroundTask extends AsyncTask<String,Void,String>{

        String URLe = "http://cricscore-api.appspot.com/csa";
        String json_string;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL(URLe);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                while ((json_string = reader.readLine())!=null){

                    builder.append(json_string + "\n");
                }

                reader.close();
                inputStream.close();
                connection.disconnect();

                return builder.toString().trim();


            } catch (MalformedURLException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            if (result != null) {

                writeToFile(result);
                progressBar.setVisibility(View.GONE);
                teamList.setVisibility(View.VISIBLE);
                txtMsg.setVisibility(View.GONE);
                adapter = new CustomAdapter(getApplicationContext(), R.layout.row);
                teamList.setAdapter(adapter);

                if (result != null) {
                    int count = 0;
                    try {
                        jsonArray = new JSONArray(readFromFile());

                        while (count < jsonArray.length()) {

                            jsonObject = jsonArray.getJSONObject(count);
                            String teamId = jsonObject.getString("id");
                            teamOne = jsonObject.getString("t1");
                            teamTwo = jsonObject.getString("t2");

                            Team team = new Team(teamId, teamOne, teamTwo);
                            adapter.add(team);

                            count++;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Team teamId = (Team) adapter.getItem(position);


                        Intent intent = new Intent(MainActivity.this, ShowScoreActivity.class);
                        String scr_id = teamId.getId().trim();
                        intent.putExtra("id", scr_id);
                        intent.putExtra("team_one",teamId.getTeamOne());
                        intent.putExtra("team_two",teamId.getTeamTwo());
                        startActivity(intent);
                    }
                });
            }else {
                txtMsg.setText("No Game avilable for today..");
            }
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    // Save json data at file
    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(MainActivity.this.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Exception "+ "File write failed: " + e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    // Read json data from file
    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}

