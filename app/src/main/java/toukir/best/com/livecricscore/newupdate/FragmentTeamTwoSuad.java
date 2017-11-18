package toukir.best.com.livecricscore.newupdate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.config.Api;
import toukir.best.com.livecricscore.newupdate.adapter.SquadAdapter;
import toukir.best.com.livecricscore.utils.Player;

/**
 * Created by toukir on 6/9/17.
 */

public class FragmentTeamTwoSuad extends Fragment {

    private RecyclerView recyclerViewSquadTwo;
    private List<Player> players = new ArrayList<Player>();
    private SquadAdapter adapter;
    private Player player;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.squad_two, null);

        //http://cricapi.com/api/fantasySquad?unique_id=1022347&apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32

        initUI(root);
        loadDataFromServer(Api.API_SQUAD+"unique_id="+SquadActivity.unique_Id+"&"+"apikey="+Api.API_KEY);


        return root;
    }

    private void loadDataFromServer(String s) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("jhsakjhaskdjashd",response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getActivity()).add(request);

    }

    private void initUI(ViewGroup root) {

    }
}
