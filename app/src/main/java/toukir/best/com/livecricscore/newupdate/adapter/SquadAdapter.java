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
import toukir.best.com.livecricscore.utils.Player;

/**
 * Created by toukir on 6/9/17.
 */



    public class SquadAdapter extends ArrayAdapter<Player> {

        Context mContext;

        public SquadAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        public SquadAdapter(Context context, int resource, List<Player> items) {
            super(context, resource, items);
            this.mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;


            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.row_squad, null);


            Player p = getItem(position);

            if (p != null) {
                TextView tt1 = (TextView) v.findViewById(R.id.playerName);

                tt1.setText(p.getName());


            }

            return v;
        }

        @Nullable
        @Override
        public Player getItem(int position) {
            return super.getItem(getCount() - position - 1);
        }
    }


