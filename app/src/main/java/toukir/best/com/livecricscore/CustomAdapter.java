package toukir.best.com.livecricscore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by toukir on 5/29/16.
 */
public class CustomAdapter extends ArrayAdapter {

    String teamOne, teamTwo;
    List list = new ArrayList();

    public CustomAdapter(Context context, int resource){
        super(context,resource);
    }

    public void add(Team object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(getCount() - position - 1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        TeamHolder holder;
        if (row==null){

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row,parent,false);

            holder = new TeamHolder();
            holder.txtTeamOne = (TextView) row.findViewById(R.id.txtT1);
            holder.txtTeamTwo = (TextView) row.findViewById(R.id.txtT2);
            holder.teamOneImage = (CircleImageView) row.findViewById(R.id.teamOneFlag);
            holder.teamTwoImage = (CircleImageView) row.findViewById(R.id.teamTwoFlag);

            row.setTag(holder);
        }else {

            holder = (TeamHolder) row.getTag();
        }

        Team team = (Team) this.getItem(position);
        teamOne = team.getTeamOne();
        teamTwo = team.getTeamTwo();
        holder.txtTeamOne.setText(teamOne);
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
        }else if (teamOne.equalsIgnoreCase("Southafrica")){
            holder.teamOneImage.setImageResource(R.drawable.southafrica);
        }else if (teamOne.equalsIgnoreCase("Zimbabwe")){
            holder.teamOneImage.setImageResource(R.drawable.zimbabwe);
        }else if (teamOne.equalsIgnoreCase("Essex")){
            holder.teamOneImage.setImageResource(R.drawable.essex);
        }else if (teamOne.equalsIgnoreCase("Lancashire")){
            holder.teamOneImage.setImageResource(R.drawable.lancashire);
        }
        else {
            holder.teamOneImage.setImageResource(R.drawable.defaults);
        }
        holder.txtTeamTwo.setText(teamTwo);

        if (teamTwo.equalsIgnoreCase("Sussex")){
            holder.teamTwoImage.setImageResource(R.drawable.sussex);
        }else if (teamTwo.equalsIgnoreCase("Hampshire")){
            holder.teamTwoImage.setImageResource(R.drawable.hampshire);
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
        }else if (teamTwo.equalsIgnoreCase("Afghnistan")){
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
        }else if (teamTwo.equalsIgnoreCase("Southafrica")){
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
        notifyDataSetChanged();
        return row;
    }

    static class TeamHolder{

        TextView txtTeamOne;
        TextView txtTeamTwo;
        CircleImageView teamOneImage;
        CircleImageView teamTwoImage;
    }
}
