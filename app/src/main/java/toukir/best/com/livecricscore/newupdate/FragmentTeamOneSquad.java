package toukir.best.com.livecricscore.newupdate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toukir.best.com.livecricscore.R;

/**
 * Created by toukir on 6/9/17.
 */

public class FragmentTeamOneSquad extends Fragment{


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.squad_one, null);

        return root;
    }
}
