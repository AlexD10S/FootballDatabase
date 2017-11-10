package alexd10s.com.footballdatabase.interfaces;

import java.util.List;

import alexd10s.com.footballdatabase.model.Players;

/**
 * Created by alex on 28/09/2017.
 */

public interface IPlayersHandler extends IFailureCallback {

    void OnGetPlayers(List<Players> players);
}
