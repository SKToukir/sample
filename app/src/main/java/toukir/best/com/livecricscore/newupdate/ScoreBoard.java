package toukir.best.com.livecricscore.newupdate;

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

import org.json.JSONException;
import org.json.JSONObject;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.config.Api;

public class ScoreBoard extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    public static String UNIQUE_ID;
    private TextView txtScore;

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

        init();

        getScore(Api.API_CRICKET_SCORE + Api.MATCH_UNIQUE_ID + "=" + UNIQUE_ID + "&" + "apikey=" + Api.API_KEY);

    }

    private void init() {
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtScore.setOnClickListener(this);
    }

    private void getScore(String s) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("FromServerdddddd", response.toString());

                try {
                    String team_one = response.getString("team-1");
                    String team_two = response.getString("team-2");
                    String dateTimeGMT = response.getString("dateTimeGMT");
                    String type = response.getString("type");
                    String innings_requirement = response.getString("innings-requirement");
                    String score = response.getString("score");


                    txtScore.setText(score);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(request);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

        }
    }
}
