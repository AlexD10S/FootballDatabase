package alexd10s.com.footballdatabase.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.adapters.TeamsAdapter;
import alexd10s.com.footballdatabase.interfaces.IPlayersHandler;
import alexd10s.com.footballdatabase.interfaces.ITeamHandler;
import alexd10s.com.footballdatabase.interfaces.ITeamsHandler;
import alexd10s.com.footballdatabase.model.Players;
import alexd10s.com.footballdatabase.model.Team;
import alexd10s.com.footballdatabase.singletons.DataSource;

public class TeamActivity extends AppCompatActivity {

    String urlTeam = "";
    String urlPlayer="";
    String urlFixtures="";
    Team team = new Team();
    ArrayList<Players> players = new ArrayList<Players>();

    TextView nameTeam;
    TextView numberPlayers;
    TextView valueTeam;
    WebView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        urlTeam = getIntent().getStringExtra("Team");
        urlPlayer = getIntent().getStringExtra("Players");
        urlFixtures = getIntent().getStringExtra("Fixtures");
        getData();
    }

    public void getData(){
        DataSource.GetDataSourceObject(this).GetTeam(urlTeam, new ITeamHandler() {
            @Override
            public void OnGetTeam(Team teamDB) {

                team = teamDB;
                getPlayers();
            }

            @Override
            public void OnFailure(String message) {
                //displayError("Login failed!", "Impossible to access to the account");
            }
        });

    }

    public void getPlayers(){
        DataSource.GetDataSourceObject(this).GetPlayers(urlPlayer, new IPlayersHandler() {
            @Override
            public void OnGetPlayers(List<Players> playersDB) {

                players.addAll(playersDB);
                setupData();
            }

            @Override
            public void OnFailure(String message) {
                //displayError("Login failed!", "Impossible to access to the account");
            }
        });

    }
    public void setupData(){
        nameTeam = (TextView) findViewById(R.id.title_tab_table);
        numberPlayers = (TextView) findViewById(R.id.team_players);
        valueTeam = (TextView) findViewById(R.id.team_value);
        logo = (WebView) findViewById(R.id.profile_summry_img);

        nameTeam.setText(team.getName());
        numberPlayers.setText(String.valueOf(players.size()) + " players");
        valueTeam.setText(team.getSquadMarketValue());
        logo.loadDataWithBaseURL(null,"<html><head></head><body><table style=\"width:100%; height:100%;\"><tr><td style=\"vertical-align:middle;\"><img src=\"" + team.getCrestUrl() + "\"></td></tr></table></body></html>","html/css", "utf-8", null);

    }
}
