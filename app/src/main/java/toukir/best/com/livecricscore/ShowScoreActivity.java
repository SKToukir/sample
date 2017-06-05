package toukir.best.com.livecricscore;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.blurry.Blurry;

public class ShowScoreActivity extends AppCompatActivity{

   // Button btnRefresh;
    TextView txtSi,txtTotal,txtOver,txtPlayerOne,txtPlayerTwo,txtLastWicket,teamOneName,teamTwoNme;
    ImageView image1, image2;
    TextView txtTeamTwoScore;
    JSONArray jsonArray;
    JSONObject jsonObject;
    CircleImageView teamOneImage,teamTwoImage;
    String score_url,si,de,total,teamOne,teamTwo;
    String json_string;
    String teamId,siT,siO;
    InterstitialAd mInterstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //mAdView = (AdView) findViewById(R.id.adView);

        AdRequest aRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(aRequest);


        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        //mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

     //   btnRefresh = (Button) findViewById(R.id.btnRefresh);
        txtLastWicket = (TextView) findViewById(R.id.txtLastWicket);
        txtPlayerOne = (TextView) findViewById(R.id.txtPlayerOne);
        txtPlayerTwo = (TextView) findViewById(R.id.txtPlayerTwo);
        txtOver = (TextView) findViewById(R.id.txtOver);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        txtSi = (TextView) findViewById(R.id.txtSi);
//        teamOneName = (TextView) findViewById(R.id.teamOneName);
//        teamTwoNme = (TextView) findViewById(R.id.teamTwoName);
        txtTeamTwoScore = (TextView) findViewById(R.id.txtTeamTwoScore);

        teamOneImage = (CircleImageView) findViewById(R.id.teamOneFlags);
        teamTwoImage = (CircleImageView) findViewById(R.id.teamTwoFlags);



        final Intent intent = getIntent();
        teamId = intent.getStringExtra("id");
        teamOne = intent.getStringExtra("team_one");
        teamTwo = intent.getStringExtra("team_two");

//        teamOneName.setText(teamOne);
//        teamTwoNme.setText(teamTwo);

        if (isNetworkConnected()) {
            try {
                new BackgroundTasks().execute(teamId);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }else {
            txtSi.setText("Please check your internet connection..");
        }

//        btnRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                Intent intent1 = new Intent(ShowScoreActivity.this,ShowScoreActivity.class);
//                intent1.putExtra("id",teamId);
//                intent1.putExtra("team_one",teamOne);
//                intent1.putExtra("team_two",teamTwo);
//                startActivity(intent1);
//            }
//        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnRefresh);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNetworkConnected()) {
                    try {
                        finish();
                Intent intent1 = new Intent(ShowScoreActivity.this,ShowScoreActivity.class);
                intent1.putExtra("id",teamId);
                intent1.putExtra("team_one",teamOne);
                intent1.putExtra("team_two",teamTwo);
                startActivity(intent1);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }else {
                    txtSi.setText("Please check your internet connection..");
                }
            }
        });

    }


    class BackgroundTasks extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {

            String id = params[0];
            score_url = "http://cricscore-api.appspot.com/csa?id="+id;
            try {
                URL url = new URL(score_url);
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

            return "No data for showing";
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                jsonArray = new JSONArray(result);
                jsonObject = jsonArray.getJSONObject(0);
                si = jsonObject.getString("si");
                de = jsonObject.getString("de");

                try{
                    Context context = teamOneImage.getContext();
                    int id = context.getResources().getIdentifier(teamOne.toLowerCase(), "drawable", context.getPackageName());
                    int idTwo = context.getResources().getIdentifier(teamTwo.toLowerCase(),"drawable",context.getPackageName());
                    teamOneImage.setImageResource(id);
                    teamTwoImage.setImageResource(idTwo);

                    txtSi.setText(si);

                    try {

                        String siOnT[] = si.split("v");
                        siO = siOnT[0];
                        siT = siOnT[1];

//                        txtTeamTwoScore.setText(siT);

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                    String deTotal[] = de.split("\\(");
                    total = deTotal[0];
                    txtTeamTwoScore.setText(total);
                    txtTotal.setText(siO);


                    String n[] = deTotal[1].split("\\)");
                    String over[] = n[0].split(",");


                    txtOver.setText(over[0]);
                    txtPlayerOne.setText(over[1]);
                    txtPlayerTwo.setText(over[2]);
                    txtLastWicket.setText(over[3]);
                }catch (Exception e){
                    txtSi.setText(total);
                    txtTotal.setText("No update");
                    txtOver.setText("");
                    txtPlayerOne.setText("No update");
                    txtPlayerTwo.setText("No update");
                    txtLastWicket.setText("No update");
                    txtTeamTwoScore.setText("No update");
                }

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitial();
        finish();
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
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

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}


