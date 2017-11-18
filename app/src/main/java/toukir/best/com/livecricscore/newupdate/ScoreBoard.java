package toukir.best.com.livecricscore.newupdate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import org.json.JSONException;
import org.json.JSONObject;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.config.Api;

public class ScoreBoard extends AppCompatActivity implements View.OnClickListener {


    private ProgressDialog pd;
    private Button btnShowSquad;
    private Toolbar toolbar;
    public static String UNIQUE_ID;
    private TextView txtScore, txtTeamOne, txtTeamTwo, txtType, txtInningsRequirement;
    String team_one,team_two,dateTimeGMT,type,innings_requirement,score;
    private AdView mAdView;
    InterstitialAd mInterstitialAd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        mAdView = (AdView) findViewById(R.id.adViews);
        AdRequest adRequestt = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequestt);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequests = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequests);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        init();
        String url = Api.API_CRICKET_SCORE + Api.MATCH_UNIQUE_ID + "=" + UNIQUE_ID + "&" + "apikey=" + Api.API_KEY;
        Log.d("URL",url);
        getScore(url);


        btnShowSquad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SquadActivity.unique_Id = UNIQUE_ID;
                SquadActivity.team_one = team_one;
                SquadActivity.team_two = team_two;

                startActivity(new Intent(ScoreBoard.this, SquadActivity.class));

            }
        });

        init();

        getScore(Api.API_CRICKET_SCORE + Api.MATCH_UNIQUE_ID + "=" + UNIQUE_ID + "&" + "apikey=" + Api.API_KEY);


    }

    private void init() {




        btnShowSquad = (Button) findViewById(R.id.btnShowSquad);
        txtInningsRequirement = (TextView) findViewById(R.id.txtInningsRequirement);
        txtType = (TextView) findViewById(R.id.txtType);
        txtTeamOne = (TextView) findViewById(R.id.txtTeamOne);
        txtTeamTwo = (TextView) findViewById(R.id.txtTeamTwo);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtScore.setOnClickListener(this);
    }

    private void getScore(String s) {

//        pd = new ProgressDialog(this);
//        pd.setMessage("Please wait..");
//        pd.show();
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("FromServerdddddd", response.toString());
//
//                pd.dismiss();
//
//                try {
//                    if (response.has("score")){
//                        team_one = response.getString("team-1");
//
//
//                       // dateTimeGMT = response.getString("dateTimeGMT");
//                        type = response.getString("stat");
//                        innings_requirement = response.getString("description");
//                        score = response.getString("score");
//
//                        txtType.setText(type);
//                        txtTeamOne.setText(team_one);
//                        txtTeamTwo.setText(team_two);
//                        txtInningsRequirement.setText(innings_requirement);
//                        txtScore.setText(score);
//                    }else {
//                        team_one = response.getString("team-1");
//                        team_two = response.getString("team-2");
//                        //dateTimeGMT = response.getString("dateTimeGMT");
//                        type = response.getString("stat");
//                        innings_requirement = response.getString("stat");
//                        //score = response.getString("score");
//
//                        txtType.setText(type);
//                        txtTeamOne.setText(team_one);
//                        txtTeamTwo.setText(team_two);
//                        txtInningsRequirement.setText(innings_requirement);
//                        //txtScore.setText(score);
//                    }
//
//                     team_one = response.getString("team-1");
//                     team_two = response.getString("team-2");
//                     //dateTimeGMT = response.getString("dateTimeGMT");
//                     type = response.getString("stat");
//                     innings_requirement = response.getString("description");
//                     score = response.getString("score");
//
//                    txtType.setText(type);
//                    txtTeamOne.setText(team_one);
//                    txtTeamTwo.setText(team_two);
//                    txtInningsRequirement.setText(innings_requirement);
//                    txtScore.setText(score);
//                    //Log.d("scoreeee",score);
//
//                try {
//                    String team_one = response.getString("team-1");
//                    String team_two = response.getString("team-2");
//                    String dateTimeGMT = response.getString("dateTimeGMT");
//                    String type = response.getString("type");
//                    String innings_requirement = response.getString("innings-requirement");
//                    String score = response.getString("score");
//
//
//                    txtScore.setText(score);
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        Volley.newRequestQueue(getApplicationContext()).add(request);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

        }
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
