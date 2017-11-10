package alexd10s.com.footballdatabase.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.activities.TeamActivity;
import alexd10s.com.footballdatabase.adapters.TableAdapter;
import alexd10s.com.footballdatabase.adapters.TeamsAdapter;
import alexd10s.com.footballdatabase.interfaces.IClubClickListener;
import alexd10s.com.footballdatabase.interfaces.ITeamsHandler;
import alexd10s.com.footballdatabase.model.Team;
import alexd10s.com.footballdatabase.singletons.DataSource;
import alexd10s.com.footballdatabase.utils.RecyclerTouchListener;
import alexd10s.com.footballdatabase.utils.RecyclerTouchListenerTeam;


public class TabTeams extends Fragment implements IClubClickListener {
    private String leagueId="";
    private String leagueName="";
    TextView mTitle;

    private RecyclerView mRecyclerView;
    private TeamsAdapter mTableAdapter;
    private LinearLayoutManager mLayoutManager;



    ArrayList<Team> listTeams = new ArrayList<Team>();

    public TabTeams() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_teams, container, false);
        leagueId = getActivity().getIntent().getStringExtra("LeagueID");
        leagueName = getActivity().getIntent().getStringExtra("LeagueName");

        setupView(v);
        return v;
    }

    private void setupView(View v){
        mTitle = (TextView) v.findViewById(R.id.title_tab_table);
        mTitle.setText(leagueName + " Teams");

        mRecyclerView =  (RecyclerView) v.findViewById(R.id.teams_recycler_view);

        DataSource.GetDataSourceObject(getActivity()).GetTeams(leagueId, new ITeamsHandler() {
            @Override
            public void OnGetTeams(List<Team> teams) {

                listTeams.addAll(teams);
                mLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(mLayoutManager);

                mTableAdapter = new TeamsAdapter(getActivity(), listTeams );
                //mDetailsAdapter.notifyDataSetChanged();

                mRecyclerView.setAdapter(mTableAdapter);


            }

            @Override
            public void OnFailure(String message) {
                //displayError("Login failed!", "Impossible to access to the account");
            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerTeam(getActivity(), mRecyclerView, this));

    }

    @Override
    public void onClick(View view, int position) {
        Intent i = new Intent(getActivity(), TeamActivity.class);
        Team club = listTeams.get(position);
        i.putExtra("Team",club.get_links().getSelf().getHref());
        i.putExtra("Players",club.get_links().getPlayers().getHref());
        i.putExtra("Fixtures",club.get_links().getFixtures().getHref());
        startActivity(i);
    }

    @Override
    public void onLongClick(View view, int position) {

    }


}
