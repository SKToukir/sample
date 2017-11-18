package toukir.best.com.livecricscore.newupdate;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.config.Api;
import toukir.best.com.livecricscore.newupdate.adapter.RecyclerAdapter;
import toukir.best.com.livecricscore.utils.Matches;
import toukir.best.com.livecricscore.utils.NetworkChangeReceiver;
import toukir.best.com.livecricscore.utils.RecyclerTouchListener;

/**
 * Created by toukirul on 6/6/2017.
 */

public class FragmentTodaysMatch extends Fragment {

    private Dialog m_dialog; //Dialog instance.
    private ProgressDialog pd;
    private Matches matches;
    private List<Matches> matchesList = new ArrayList<Matches>();
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;
    private AdView mAdView;
    public static Fragment newInstance(Context context) {
        FragmentTodaysMatch f = new FragmentTodaysMatch();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_main, null);

        mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        pd = new ProgressDialog(getActivity());
        pd.setMessage("Please wait..");

        if (new NetworkChangeReceiver().isNetworkAvailable(getActivity())){
            pd.show();
        }else {
            new NetworkChangeReceiver().showConnectionDialog(getActivity());
        }

        recyclerView = (RecyclerView) root.findViewById(R.id.listTodaysMatch);
        adapter = new RecyclerAdapter(matchesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadDataTodaySMatch(Api.API_MATCHES + Api.API_KEY);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                ScoreBoard.UNIQUE_ID = matchesList.get(position).getUnique_id();
              //  startActivity(new Intent(getActivity(),ScoreBoard.class));

                pd = new ProgressDialog(getActivity());
                pd.setMessage("Please wait..");

                getScrore(matchesList.get(position).getUnique_id());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return root;
    }

    private void getScrore(String unique_id) {

        String url = Api.API_CRICKET_SCORE + Api.MATCH_UNIQUE_ID + "=" + unique_id + "&" + "apikey=" + Api.API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("FromServerdddddd", response.toString());

                try {

                    if (response.has("score")){
                        // dateTimeGMT = response.getString("dateTimeGMT");
                        String team_one = response.getString("team-1");
                        String team_two = response.getString("team-2");
                        String type = response.getString("stat");
                        String innings_requirement = response.getString("description");
                        String score = response.getString("score");

                        showScoreDialog(type, innings_requirement, score,team_one, team_two);


                    }else {
                        String team_one = response.getString("team-1");
                        String team_two = response.getString("team-2");
                        //String type = response.getString("stat");
                        String innings_requirement = response.getString("stat");
                        showScoreDialog("", innings_requirement, "",team_one, team_two);
                        //score = response.getString("score");
                        //txtScore.setText(score);
                    }

                    String type = response.getString("stat");
                    String innings_requirement = response.getString("description");
                    String score = response.getString("score");

                    //showScoreDialog(type, innings_requirement, score);



                    //Log.d("scoreeee",score);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(request);

    }

    private void showScoreDialog(String type, final String innings_requirement, String score, String team_one, String team_two) {
        Log.d("Dialog","l");

        pd.dismiss();

        m_dialog = new Dialog(getContext(), R.style.Dialog_No_Border);
        m_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        m_dialog.setContentView(R.layout.custom_dialog);


        TextView txtTitle = (TextView) m_dialog.findViewById(R.id.txtTitle);
        final TextView txtDescription = (TextView) m_dialog.findViewById(R.id.txtDescription);
        TextView ok = (TextView) m_dialog.findViewById(R.id.cadbtnOk);
        TextView share = (TextView) m_dialog.findViewById(R.id.cadbtnShare);

        txtTitle.setText(team_one+" vs "+team_two);
        txtDescription.setText(innings_requirement);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_dialog.dismiss();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, innings_requirement);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });

        m_dialog.show();


//        new MaterialStyledDialog.Builder(getContext())
//                .setTitle(team_one + " VS " + team_two)
//                .setDescription(innings_requirement)
//                .set
//                .setIcon(R.mipmap.ic_launcher)
//                .withDarkerOverlay(true)
//                .setHeaderColor(R.color.white)
//                .withDialogAnimation(true)
//                //.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
//                .show();
    }



    private void loadDataTodaySMatch(String s) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("FromServer", response.toString());
                pd.dismiss();
                try {
                    JSONArray array = response.getJSONArray("matches");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        matches = new Matches();
                        matches.setUnique_id(object.getString(Api.MATCHE_UNIQUE_ID));
                        matches.setDate(object.getString(Api.MATCH_DATE));
                        matches.setTeam_two(object.getString(Api.CRICKET_SCORE_TEAM_TWO));
                        matches.setTeam_one(object.getString(Api.CRICKET_SCORE_TEAM_ONE));

                        matchesList.add(matches);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getActivity()).add(request);

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
}
