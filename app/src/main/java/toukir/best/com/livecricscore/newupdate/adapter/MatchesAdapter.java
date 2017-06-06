package toukir.best.com.livecricscore.newupdate.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.utils.Matches;

/**
 * Created by toukirul on 6/6/2017.
 */

public class MatchesAdapter extends ArrayAdapter<Matches> {

    Context mContext;

    public MatchesAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public MatchesAdapter(Context context, int resource, List<Matches> items) {
        super(context, resource, items);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;


        LayoutInflater vi;
        vi = LayoutInflater.from(mContext);
        v = vi.inflate(R.layout.row, null);


        Matches p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.txtT1);
            TextView tt2 = (TextView) v.findViewById(R.id.txtT2);

            tt1.setText(p.getTeam_one());
            tt2.setText(p.getTeam_two());


        }

        return v;
    }

    @Nullable
    @Override
    public Matches getItem(int position) {
        return super.getItem(getCount() - position - 1);
    }
}

