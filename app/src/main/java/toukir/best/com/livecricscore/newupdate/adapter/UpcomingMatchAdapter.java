package toukir.best.com.livecricscore.newupdate.adapter;

/**
 * Created by toukir on 11/18/17.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.utils.UpcomingMatch;

/**
 * Created by toukir on 6/6/17.
 */

public class UpcomingMatchAdapter extends RecyclerView.Adapter<UpcomingMatchAdapter.MyViewHolder> {

    private List<UpcomingMatch> upcomingMatchList;

    public UpcomingMatchAdapter(List<UpcomingMatch> list){
        this.upcomingMatchList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_match_calender, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        UpcomingMatch match = upcomingMatchList.get(position);

        holder.txtUpcomingMatchDitails.setText(match.getName());
        holder.txtUpcomingMatchDate.setText(match.getDate());
    }

    @Override
    public int getItemCount() {
        return upcomingMatchList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtUpcomingMatchDitails, txtUpcomingMatchDate;

        public MyViewHolder(View view) {
            super(view);
            txtUpcomingMatchDitails = (TextView) view.findViewById(R.id.txtUpcomingMatchDetails);
            txtUpcomingMatchDate = (TextView) view.findViewById(R.id.txtUpcomingMatchDate);
        }
    }
}
