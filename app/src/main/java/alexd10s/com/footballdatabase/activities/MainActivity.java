package alexd10s.com.footballdatabase.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.adapters.LeagueAdapter;
import alexd10s.com.footballdatabase.apis.APIHandler;
import alexd10s.com.footballdatabase.interfaces.ILeagueClickListener;
import alexd10s.com.footballdatabase.interfaces.ILeaguesHandler;
import alexd10s.com.footballdatabase.model.League;
import alexd10s.com.footballdatabase.singletons.DataSource;
import alexd10s.com.footballdatabase.utils.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity implements ILeagueClickListener {


    private AlertDialog.Builder errorMsg;
    private Context cntx = this;
    ProgressDialog dialog;

    private RecyclerView mRecyclerView;
    private LeagueAdapter mLeagueAdapter;
    private LinearLayoutManager mLayoutManager;

    private Spinner spinnerYear;

    ArrayList<League> arrayLeagues = new ArrayList<League>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorMsg = new AlertDialog.Builder(this);
        SetupProgressDialog();

        spinnerYear = (Spinner) findViewById(R.id.spinner_years);
        spinnerYear.setVisibility(View.VISIBLE);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                DisplayLeagues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        DisplayLeagues();

    }

    private void DisplayLeagues(){
        mRecyclerView =  (RecyclerView) findViewById(R.id.leagues_recycler_view);

        String year= String.valueOf(spinnerYear.getSelectedItem());
        arrayLeagues.clear();
        dialog.show();

        DataSource.GetDataSourceObject(this).GetLeagues(year, new ILeaguesHandler() {
                    @Override
                    public void OnGetLeagues(List<League> list) {
                        arrayLeagues.addAll(list);
                        mLayoutManager = new LinearLayoutManager(getBaseContext());
                        mRecyclerView.setLayoutManager(mLayoutManager);

                        mLeagueAdapter = new LeagueAdapter(getBaseContext(), arrayLeagues );
                        //mDetailsAdapter.notifyDataSetChanged();

                        mRecyclerView.setAdapter(mLeagueAdapter);
                        dialog.cancel();
                    }

                    @Override
                    public void OnFailure(String message) {
                        displayError("Login failed!", "Impossible to access to the account");
                        dialog.cancel();
                    }
                });
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, this));

    }


    private void SetupProgressDialog() {
        dialog = new ProgressDialog(this); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading. Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
    }

    private void displayError(String title, String errorMessage){
        errorMsg.setTitle(title);
        errorMsg.setMessage(errorMessage);
        errorMsg.setIcon(R.mipmap.ic_error_black_24dp);
        errorMsg.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int whichButton) {
                d.dismiss();
            }
        });
        errorMsg.show();
    }

    @Override
    public void onClick(View view, int position) {
        League leagueSelected = arrayLeagues.get(position);
        Intent intent = new Intent(getBaseContext(), LeagueActivity.class);
        intent.putExtra("LeagueID",String.valueOf(leagueSelected.getId()));
        intent.putExtra("LeagueName",leagueSelected.getCaption());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
