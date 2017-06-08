package toukir.best.com.livecricscore.newupdate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.config.Api;
import toukir.best.com.livecricscore.newupdate.adapter.RecyclerAdapter;
import toukir.best.com.livecricscore.utils.Matches;
import toukir.best.com.livecricscore.utils.RecyclerTouchListener;

/**
 * Created by toukirul on 6/6/2017.
 */

public class FragmentTodaysMatch extends Fragment {

    private Matches matches;
    private List<Matches> matchesList = new ArrayList<Matches>();
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;

    public static Fragment newInstance(Context context) {
        FragmentTodaysMatch f = new FragmentTodaysMatch();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_main, null);

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

                Toast.makeText(getActivity(),matchesList.get(position).getUnique_id(),Toast.LENGTH_LONG).show();
                ScoreBoard.UNIQUE_ID = matchesList.get(position).getUnique_id();
                startActivity(new Intent(getActivity(),ScoreBoard.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return root;
    }


    private void loadDataTodaySMatch(String s) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("FromServer", response.toString());

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
}
