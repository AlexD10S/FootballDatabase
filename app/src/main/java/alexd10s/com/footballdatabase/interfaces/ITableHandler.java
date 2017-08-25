package alexd10s.com.footballdatabase.interfaces;

import java.util.List;

import alexd10s.com.footballdatabase.model.LeagueTable;

/**
 * Created by alex on 13/08/2017.
 */

public interface ITableHandler extends IFailureCallback{
    void OnGetTable(LeagueTable list);
}
