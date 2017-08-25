package alexd10s.com.footballdatabase.model;

import java.util.ArrayList;

/**
 * Created by alex on 13/08/2017.
 */

public class LeagueTable {
    private String mLeagueCaption;
    private int matchday;
    private ArrayList<Standing> standing;

    public String getLeagueCaption() {
        return mLeagueCaption;
    }

    public void setLeagueCaption(String LeagueCaption) {
        this.mLeagueCaption = LeagueCaption;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public ArrayList<Standing> getStanding() {
        return standing;
    }

    public void setStanding(ArrayList<Standing> standing) {
        this.standing = standing;
    }
}
