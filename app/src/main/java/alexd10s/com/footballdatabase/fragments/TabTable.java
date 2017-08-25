package alexd10s.com.footballdatabase.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.adapters.LeagueAdapter;
import alexd10s.com.footballdatabase.adapters.TableAdapter;
import alexd10s.com.footballdatabase.interfaces.ILeaguesHandler;
import alexd10s.com.footballdatabase.interfaces.ITableHandler;
import alexd10s.com.footballdatabase.model.League;
import alexd10s.com.footballdatabase.model.LeagueTable;
import alexd10s.com.footballdatabase.singletons.DataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabTable extends Fragment {

    private String leagueId="";
    private String leagueName="";
    TextView mTitle;

    private RecyclerView mRecyclerView;
    private TableAdapter mTableAdapter;
    private LinearLayoutManager mLayoutManager;


    public TabTable() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_table, container, false);
        leagueId = getActivity().getIntent().getStringExtra("LeagueID");
        leagueName = getActivity().getIntent().getStringExtra("LeagueName");

        setupView(v);
        return v;
    }

    private void setupView(View v){
        mTitle = (TextView) v.findViewById(R.id.title_tab_table);
        mTitle.setText(leagueName + "Table");

        mRecyclerView =  (RecyclerView) v.findViewById(R.id.table_recycler_view);

        DataSource.GetDataSourceObject(getActivity()).GetTable(leagueId, new ITableHandler() {
            @Override
            public void OnGetTable(LeagueTable leagueTable) {
                mLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(mLayoutManager);

                mTableAdapter = new TableAdapter(getActivity(), leagueTable.getStanding() );
                //mDetailsAdapter.notifyDataSetChanged();

                mRecyclerView.setAdapter(mTableAdapter);
            }

            @Override
            public void OnFailure(String message) {
                //displayError("Login failed!", "Impossible to access to the account");
            }
        });

    }

}
