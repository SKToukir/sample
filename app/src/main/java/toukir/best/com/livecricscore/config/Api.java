package toukir.best.com.livecricscore.config;

/**
 * Created by toukir on 6/1/17.
 */

public class Api {

    /**http://cricapi.com/api/cricketScore?unique_id=1022347&apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32**/

    public static final String API_KEY = "5ns1uE5qMph2iOe3mGw4DGqTbd32";
    public static final String UNIQUE_ID = "1022347";

    // GET method.....Returns current matches list
    public static final String API_MATCHES = "http://cricapi.com/api/matches?apikey=";
    public static final String MATCHE_UNIQUE_ID = "unique_id";
    public static final String MATCHE_DATE = "date";
    public static final String MATCHE_SQUAD = "squad";
    public static final String MATCHE_TEAM_ONE = "team-1";
    public static final String MATCHE_TEAM_TWO  = "team-2";
    public static final String MATCHE_STARTED = "matchStarted";



    // http://cricapi.com/api/cricketScore?unique_id=1022347&apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32
    public static final String API_CRICKET_SCORE = "http://cricapi.com/api/cricketScore?";
    public static final String CRICKET_SCORE_TEAM_ONE = "team-1";
    public static final String CRICKET_SCORE_TEAM_TWO = "team-2";
    public static final String CRICKET_SCORE_DATE_TIME = "dateTimeGMT";
    public static final String CRICKET_SCORE_TYPE = "type";
    public static final String CRICKET_SCORE = "score";
    public static final String CRICKET_SCORE_INNINGS_REQUIREMENT = "score";

    // http://cricapi.com/api/matchCalendar?apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32
    public static final String MATCH_CALENDER = "http://cricapi.com/api/matchCalendar?apikey=";
    public static final String MATCH_NAME = "name";
    public static final String MATCH_DATE = "date";
    public static final String MATCH_UNIQUE_ID = "unique_id";

    // show currennt matche's player details. Just put current match uniwue id to get all player list of two team
    // http://cricapi.com/api/fantasySquad?unique_id=1022347&apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32
    public static final String API_SQUAD = "http://cricapi.com/api/fantasySquad?";
    public static final String PLAYER_ID = "pid";
    public static final String PLAYER_NAME = "name";

    // now here we will get player detail by passing pid
    // http://cricapi.com/api/playerStats?pid=56143&apikey=5ns1uE5qMph2iOe3mGw4DGqTbd32
    public static final String API_PLAYER_DETAILS = "http://cricapi.com/api/playerStats";
    public static final String PUBLISH_DATE = "pubDate";
    public static final String IMAGE_URL = "imageURL";
    public static final String CPOUNTRY = "imageURL";
    public static final String PROFILE = "profile";
    public static final String BOWLING_STYLE = "bowlingStyle";
    public static final String BATTING_STYLE = "battingStyle";
    public static final String PLAYING_ROLE = "playingRole";
    public static final String MAJOR_TEAMS = "majorTeams";
    public static final String FULL_NAME = "fullName";
    public static final String DATA = "data";

    public static final String BATTING = "batting";
    /* ------------TWEENTY20-------------- */
    public static final String TWEENTY20 = "twenty20";
    public static final String FIFTY = "50";
    public static final String HUNDRED = "100";
    public static final String ST = "st";
    public static final String CT = "ct";
    public static final String SIXES = "6s";
    public static final String FOURS = "4s";
    public static final String SR = "sr";
    public static final String BF = "BF";
    public static final String AVE = "Ave";
    public static final String HIGEST = "hs";
    public static final String RUNS = "Runs";
    public static final String NO = "No";
    public static final String INNINGS = "Inns";
    public static final String MATCHES = "Mat";
    /* ------------ODIS-------------- */
    public static final String ODIS = "ODIs";
    public static final String TESTS = "tests";






}
