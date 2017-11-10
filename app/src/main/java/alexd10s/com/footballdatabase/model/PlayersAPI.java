package alexd10s.com.footballdatabase.model;

import java.util.ArrayList;

/**
 * Created by alex on 28/09/2017.
 */

public class PlayersAPI {
    private String count;
    private ArrayList<Players> players;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<Players> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }
}
