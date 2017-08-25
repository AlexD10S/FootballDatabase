package alexd10s.com.footballdatabase.interfaces;

import java.util.List;

import alexd10s.com.footballdatabase.model.League;

/**
 * Created by alex on 13/08/2017.
 */

public interface ILeaguesHandler extends IFailureCallback{
    void OnGetLeagues(List<League> list);
}
