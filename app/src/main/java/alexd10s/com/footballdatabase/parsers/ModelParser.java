package alexd10s.com.footballdatabase.parsers;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alexd10s.com.footballdatabase.model.League;
import alexd10s.com.footballdatabase.model.LeagueTable;

/**
 * Created by alex on 13/08/2017.
 */

public class ModelParser {

    static Gson gson = new Gson();

    public static List<League> GetLeagues(String result) {
        List<League> list = new ArrayList<>();
        try {
            list = Arrays.asList(gson.fromJson(result, League[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public static LeagueTable GetTable(String result) {
        LeagueTable league = new LeagueTable();
        try {
            league = gson.fromJson(result, LeagueTable.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (league);
    }
}
