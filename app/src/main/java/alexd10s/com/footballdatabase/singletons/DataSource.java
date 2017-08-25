package alexd10s.com.footballdatabase.singletons;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import alexd10s.com.footballdatabase.apis.APIHandler;
import alexd10s.com.footballdatabase.interfaces.ApiCallback;
import alexd10s.com.footballdatabase.interfaces.ILeaguesHandler;
import alexd10s.com.footballdatabase.interfaces.ITableHandler;
import alexd10s.com.footballdatabase.model.League;
import alexd10s.com.footballdatabase.model.LeagueTable;
import alexd10s.com.footballdatabase.parsers.ModelParser;

/**
 * Created by alex on 13/08/2017.
 */

public class DataSource {

    private Context context;
    private DataSource(Context cntx) {
        this.context = cntx;
    }

    static DataSource source = null;

    public static DataSource GetDataSourceObject(Context cntx) {

        if (source == null)
            source = new DataSource(cntx);

        return source;
    }

    /****************************************************/
    // ------ Access API methods     -------------------.
    /****************************************************/

    public void GetLeagues(String year,final ILeaguesHandler handler) {
        if(handler == null)
            return;
        APIHandler.GetObject(this.context).GetLeagues(year,new ApiCallback(){
            List leagues = new ArrayList<League>();
            @Override
            public void OnSuccess(String result) {

                try{
                    leagues = ModelParser.GetLeagues(result.toString());
                    handler.OnGetLeagues(leagues);
                }
                catch (Exception ex){
                    handler.OnFailure(ex.getMessage());
                }
            }

            @Override
            public void OnFailure(String message) {
                handler.OnFailure(message);
            }
        });
    }

    public void GetTable(String id,final ITableHandler handler) {
        if(handler == null)
            return;
        APIHandler.GetObject(this.context).GetTable(id,new ApiCallback(){
            LeagueTable league = new LeagueTable();
            @Override
            public void OnSuccess(String result) {

                try{
                    league = ModelParser.GetTable(result.toString());
                    handler.OnGetTable(league);
                }
                catch (Exception ex){
                    handler.OnFailure(ex.getMessage());
                }
            }

            @Override
            public void OnFailure(String message) {
                handler.OnFailure(message);
            }
        });
    }


    /****************************************************/
    // ------ Private methods         -------------------.
    /****************************************************/

}
