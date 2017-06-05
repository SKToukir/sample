package toukir.best.com.livecricscore;

/**
 * Created by toukir on 5/29/16.
 */
public class Team {

    private String id;
    private String teamOne;
    private String teamTwo;

    Team(String id, String teamOne, String teamTwo){

        this.id = id;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }
}
