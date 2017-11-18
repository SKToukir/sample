package toukir.best.com.livecricscore.newupdate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toukir.best.com.livecricscore.R;

/**
 * Created by toukir on 11/18/17.
 */

public class FragmentUpcomingMatches extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming_matches, container, false);

        return view;
    }
}
