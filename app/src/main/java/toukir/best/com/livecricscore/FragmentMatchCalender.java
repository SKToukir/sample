package toukir.best.com.livecricscore;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import toukir.best.com.livecricscore.config.Api;
import toukir.best.com.livecricscore.newupdate.adapter.MatchCalenderAdapter;
import toukir.best.com.livecricscore.utils.MatchCalender;

/**
 * Created by toukir on 6/6/17.
 */

public class FragmentMatchCalender extends Fragment {

    private ProgressDialog pd;
    private RecyclerView recyclerUpcomingMatch;
    private List<MatchCalender> matchCalenderList = new ArrayList<MatchCalender>();
    private MatchCalenderAdapter adapter;
    private MatchCalender matches;
    private AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_match_calender, null);

        initUI(root);
        loadDataFromServer(Api.MATCH_CALENDER+Api.API_KEY);
        return root;
    }

    private void loadDataFromServer(String s) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("FromServer", response.toString());
                try {
                    JSONArray array = response.getJSONArray("data");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        matches = new MatchCalender();
                        matches.setDate(object.getString(Api.MATCH_DATE));
                        matches.setUnique_id(object.getString(Api.MATCHE_UNIQUE_ID));
                        matches.setName(object.getString(Api.MATCH_NAME));

                        matchCalenderList.add(matches);
                        recyclerUpcomingMatch.setAdapter(adapter);
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

    private void initUI(ViewGroup root) {

        mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        recyclerUpcomingMatch = (RecyclerView) root.findViewById(R.id.recyclerMatchCalender);
        adapter = new MatchCalenderAdapter(matchCalenderList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerUpcomingMatch.setLayoutManager(mLayoutManager);
        recyclerUpcomingMatch.setItemAnimator(new DefaultItemAnimator());
        recyclerUpcomingMatch.setAdapter(adapter);


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
