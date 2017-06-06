package toukir.best.com.livecricscore.newupdate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.utils.Matches;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Matches> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView team_one, team_two;
        public ImageView teamOneImage, teamTwoImage;

        public MyViewHolder(View view) {
            super(view);
            team_one = (TextView) view.findViewById(R.id.txtT1);
            team_two = (TextView) view.findViewById(R.id.txtT2);
            teamOneImage = (ImageView) view.findViewById(R.id.teamOneFlag);
            teamTwoImage = (ImageView) view.findViewById(R.id.teamTwoFlag);

        }
    }


    public RecyclerAdapter(List<Matches> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Matches matches = moviesList.get(position);
        holder.team_one.setText(matches.getTeam_one());
        holder.team_two.setText(matches.getTeam_two());

        String teamOne = matches.getTeam_one();
        String teamTwo = matches.getTeam_two();

        if (teamOne.equalsIgnoreCase("Sussex")){
            holder.teamOneImage.setImageResource(R.drawable.sussex);
        }else if (teamOne.equalsIgnoreCase("Hampshire")){
            holder.teamOneImage.setImageResource(R.drawable.hampshire);
        }else if (teamOne.equalsIgnoreCase("Nottinghamshire")){
            holder.teamOneImage.setImageResource(R.drawable.nottinghamshire);
        }else if (teamOne.equalsIgnoreCase("Yorkshire")){
            holder.teamOneImage.setImageResource(R.drawable.yorkshire);
        }else if (teamOne.equalsIgnoreCase("Derbyshire")){
            holder.teamOneImage.setImageResource(R.drawable.derbyshire);
        }else if (teamOne.equalsIgnoreCase("Warwickshire")){
            holder.teamOneImage.setImageResource(R.drawable.warwickshire);
        }else if (teamOne.equalsIgnoreCase("Surrey")){
            holder.teamOneImage.setImageResource(R.drawable.surrey);
        }else if (teamOne.equalsIgnoreCase("Middlesex")){
            holder.teamOneImage.setImageResource(R.drawable.middlesex);
        }else if (teamOne.equalsIgnoreCase("Gloucestershire")){
            holder.teamOneImage.setImageResource(R.drawable.gloucestershire);
        }else if (teamOne.equalsIgnoreCase("Somerset")){
            holder.teamOneImage.setImageResource(R.drawable.somerset);
        }else if (teamOne.equalsIgnoreCase("Glamorgan")){
            holder.teamOneImage.setImageResource(R.drawable.glamorgan);
        }else if (teamOne.equalsIgnoreCase("Kent")){
            holder.teamOneImage.setImageResource(R.drawable.kent);
        }else if (teamOne.equalsIgnoreCase("Northamptonshire")){
            holder.teamOneImage.setImageResource(R.drawable.northamptonshire);
        }else if (teamOne.equalsIgnoreCase("Durham")){
            holder.teamOneImage.setImageResource(R.drawable.durham);
        }else if (teamOne.equalsIgnoreCase("Leicestershire")){
            holder.teamOneImage.setImageResource(R.drawable.leicestershire);
        }else if (teamOne.equalsIgnoreCase("Worcestershire")){
            holder.teamOneImage.setImageResource(R.drawable.worcestershire);
        }else if (teamOne.equalsIgnoreCase("Bangladesh")){
            holder.teamOneImage.setImageResource(R.drawable.bangladesh);
        }else if (teamOne.equalsIgnoreCase("Afghnistan")){
            holder.teamOneImage.setImageResource(R.drawable.afghanistan);
        }else if (teamOne.equalsIgnoreCase("India")){
            holder.teamOneImage.setImageResource(R.drawable.india);
        }else if (teamOne.equalsIgnoreCase("Pakistan")){
            holder.teamOneImage.setImageResource(R.drawable.pakistan);
        }else if (teamOne.equalsIgnoreCase("Sri Lanka")){
            holder.teamOneImage.setImageResource(R.drawable.srilanka);
        }else if (teamOne.equalsIgnoreCase("Arab amirat")){
            holder.teamOneImage.setImageResource(R.drawable.arabamirat);
        }else if (teamOne.equalsIgnoreCase("Australia")){
            holder.teamOneImage.setImageResource(R.drawable.australia);
        }else if (teamOne.equalsIgnoreCase("England")){
            holder.teamOneImage.setImageResource(R.drawable.england);
        }else if (teamOne.equalsIgnoreCase("Hongkong")){
            holder.teamOneImage.setImageResource(R.drawable.hongkong);
        }else if (teamOne.equalsIgnoreCase("Ireland")){
            holder.teamOneImage.setImageResource(R.drawable.ireland);
        }else if (teamOne.equalsIgnoreCase("Scotland")){
            holder.teamOneImage.setImageResource(R.drawable.scotland);
        }else if (teamOne.equalsIgnoreCase("South Africa")){
            holder.teamOneImage.setImageResource(R.drawable.southafrica);
        }else if (teamOne.equalsIgnoreCase("South Africa A")){
            holder.teamOneImage.setImageResource(R.drawable.southafrica);
        }else if (teamOne.equalsIgnoreCase("Zimbabwe")){
            holder.teamOneImage.setImageResource(R.drawable.zimbabwe);
        }else if (teamOne.equalsIgnoreCase("Essex")){
            holder.teamOneImage.setImageResource(R.drawable.essex);
        }else if (teamOne.equalsIgnoreCase("Lancashire")){
            holder.teamOneImage.setImageResource(R.drawable.lancashire);
        }else if (teamOne.equalsIgnoreCase("West Indies")){
            holder.teamOneImage.setImageResource(R.drawable.westindies);
        }else if (teamOne.equalsIgnoreCase("New Zealand")){
            holder.teamOneImage.setImageResource(R.drawable.newzealand);
        }else if (teamOne.equalsIgnoreCase("Namibia")){
            holder.teamOneImage.setImageResource(R.drawable.namibia);
        }else if (teamOne.equalsIgnoreCase("England Lions")){
            holder.teamOneImage.setImageResource(R.drawable.englandlions);
        }
        else {
            holder.teamOneImage.setImageResource(R.drawable.defaults);
        }

        if (teamTwo.equalsIgnoreCase("Sussex")){
            holder.teamTwoImage.setImageResource(R.drawable.sussex);
        }else if (teamTwo.equalsIgnoreCase("South Africa A")){
            holder.teamTwoImage.setImageResource(R.drawable.southafrica);
        }else if (teamTwo.equalsIgnoreCase("England Lions")){
            holder.teamTwoImage.setImageResource(R.drawable.englandlions);
        }else if (teamTwo.equalsIgnoreCase("Namibia")){
            holder.teamTwoImage.setImageResource(R.drawable.namibia);
        }else if (teamTwo.equalsIgnoreCase("Hampshire")){
            holder.teamTwoImage.setImageResource(R.drawable.hampshire);
        }else if (teamTwo.equalsIgnoreCase("New Zealand")){
            holder.teamTwoImage.setImageResource(R.drawable.newzealand);
        }else if (teamTwo.equalsIgnoreCase("Nottinghamshire")){
            holder.teamTwoImage.setImageResource(R.drawable.nottinghamshire);
        }else if (teamTwo.equalsIgnoreCase("Yorkshire")){
            holder.teamTwoImage.setImageResource(R.drawable.yorkshire);
        }else if (teamTwo.equalsIgnoreCase("Derbyshire")){
            holder.teamTwoImage.setImageResource(R.drawable.derbyshire);
        }else if (teamTwo.equalsIgnoreCase("Warwickshire")){
            holder.teamTwoImage.setImageResource(R.drawable.warwickshire);
        }else if (teamTwo.equalsIgnoreCase("Surrey")){
            holder.teamTwoImage.setImageResource(R.drawable.surrey);
        }else if (teamTwo.equalsIgnoreCase("Middlesex")){
            holder.teamTwoImage.setImageResource(R.drawable.middlesex);
        }else if (teamTwo.equalsIgnoreCase("Gloucestershire")){
            holder.teamTwoImage.setImageResource(R.drawable.gloucestershire);
        }else if (teamTwo.equalsIgnoreCase("Somerset")){
            holder.teamTwoImage.setImageResource(R.drawable.somerset);
        }else if (teamTwo.equalsIgnoreCase("Glamorgan")){
            holder.teamTwoImage.setImageResource(R.drawable.glamorgan);
        }else if (teamTwo.equalsIgnoreCase("Kent")){
            holder.teamTwoImage.setImageResource(R.drawable.kent);
        }else if (teamTwo.equalsIgnoreCase("Northamptonshire")){
            holder.teamTwoImage.setImageResource(R.drawable.northamptonshire);
        }else if (teamTwo.equalsIgnoreCase("Durham")){
            holder.teamTwoImage.setImageResource(R.drawable.durham);
        }else if (teamTwo.equalsIgnoreCase("Leicestershire")){
            holder.teamTwoImage.setImageResource(R.drawable.leicestershire);
        }else if (teamTwo.equalsIgnoreCase("Worcestershire")){
            holder.teamTwoImage.setImageResource(R.drawable.worcestershire);
        }else if (teamTwo.equalsIgnoreCase("Bangladesh")){
            holder.teamTwoImage.setImageResource(R.drawable.bd);
        }else if (teamTwo.equalsIgnoreCase("Afghanistan")){
            holder.teamTwoImage.setImageResource(R.drawable.afghanistan);
        }else if (teamTwo.equalsIgnoreCase("India")){
            holder.teamTwoImage.setImageResource(R.drawable.india);
        }else if (teamTwo.equalsIgnoreCase("Pakistan")){
            holder.teamTwoImage.setImageResource(R.drawable.pakistan);
        }else if (teamTwo.equalsIgnoreCase("Sri Lanka")){
            holder.teamTwoImage.setImageResource(R.drawable.srilanka);
        }else if (teamTwo.equalsIgnoreCase("Arab amirat")){
            holder.teamTwoImage.setImageResource(R.drawable.arabamirat);
        }else if (teamTwo.equalsIgnoreCase("Australia")){
            holder.teamTwoImage.setImageResource(R.drawable.australia);
        }else if (teamTwo.equalsIgnoreCase("England")){
            holder.teamTwoImage.setImageResource(R.drawable.england);
        }else if (teamTwo.equalsIgnoreCase("Hongkong")){
            holder.teamTwoImage.setImageResource(R.drawable.hongkong);
        }else if (teamTwo.equalsIgnoreCase("Ireland")){
            holder.teamTwoImage.setImageResource(R.drawable.ireland);
        }else if (teamTwo.equalsIgnoreCase("Scotland")){
            holder.teamTwoImage.setImageResource(R.drawable.scotland);
        }else if (teamTwo.equalsIgnoreCase("South Africa")){
            holder.teamTwoImage.setImageResource(R.drawable.southafrica);
        }else if (teamTwo.equalsIgnoreCase("Zimbabwe")){
            holder.teamTwoImage.setImageResource(R.drawable.zimbabwe);
        }else if (teamTwo.equalsIgnoreCase("Essex")){
            holder.teamTwoImage.setImageResource(R.drawable.essex);
        }else if (teamTwo.equalsIgnoreCase("West Indies")){
            holder.teamTwoImage.setImageResource(R.drawable.westindies);
        }else if (teamTwo.equalsIgnoreCase("Lancashire")){
            holder.teamTwoImage.setImageResource(R.drawable.lancashire);
        }
        else {
            holder.teamTwoImage.setImageResource(R.drawable.defaults);
        }



    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}