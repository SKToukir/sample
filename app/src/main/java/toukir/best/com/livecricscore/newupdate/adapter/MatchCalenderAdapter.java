package toukir.best.com.livecricscore.newupdate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.utils.MatchCalender;

/**
 * Created by toukir on 6/6/17.
 */

public class MatchCalenderAdapter extends RecyclerView.Adapter<MatchCalenderAdapter.MyViewHolder> {

    private List<MatchCalender> matchCalenderList;

    public MatchCalenderAdapter(List<MatchCalender> list){
        this.matchCalenderList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_match_calender, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MatchCalender match = matchCalenderList.get(position);

        holder.txtUpcomingMatchDitails.setText(match.getName());
        holder.txtUpcomingMatchDate.setText(match.getDate());
    }

    @Override
    public int getItemCount() {
        return matchCalenderList.size();
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
