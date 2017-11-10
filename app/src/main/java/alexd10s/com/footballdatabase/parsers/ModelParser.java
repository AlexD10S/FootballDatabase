package alexd10s.com.footballdatabase.parsers;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alexd10s.com.footballdatabase.model.League;
import alexd10s.com.footballdatabase.model.LeagueTable;
import alexd10s.com.footballdatabase.model.Players;
import alexd10s.com.footballdatabase.model.PlayersAPI;
import alexd10s.com.footballdatabase.model.Team;
import alexd10s.com.footballdatabase.model.TeamsAPI;

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

    public static List<Team> GetTeams(String result) {
        List<Team> list = new ArrayList<>();
        try {
            TeamsAPI teamAPI = gson.fromJson(result, TeamsAPI.class);
            list = teamAPI.getTeams();
            //list = Arrays.asList(gson.fromJson(result, Team[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public static Team GetTeam(String result) {
        Team list = new Team();
        try {
            list = gson.fromJson(result, Team.class);
            //list = teamAPI.getTeams();
            //list = Arrays.asList(gson.fromJson(result, Team[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public static List<Players> GetPlayers(String result) {
        List<Players> list = new ArrayList<>();
        try {
            PlayersAPI playersAPI = gson.fromJson(result, PlayersAPI.class);
            list = playersAPI.getPlayers();
            //list = Arrays.asList(gson.fromJson(result, Team[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }
}
