package alexd10s.com.footballdatabase.model;

import java.util.ArrayList;

/**
 * Created by alex on 07/09/2017.
 */

public class TeamsAPI {
    private String count;
    private ArrayList<Team> teams;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
