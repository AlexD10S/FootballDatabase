package alexd10s.com.footballdatabase.interfaces;


import java.util.ArrayList;
import java.util.List;

import alexd10s.com.footballdatabase.model.Team;

/**
 * Created by alex on 06/09/2017.
 */

public interface ITeamsHandler extends IFailureCallback {
    void OnGetTeams(List<Team> team);


}
