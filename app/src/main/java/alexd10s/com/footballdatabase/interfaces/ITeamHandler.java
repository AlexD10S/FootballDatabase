package alexd10s.com.footballdatabase.interfaces;



import alexd10s.com.footballdatabase.model.Team;

/**
 * Created by alex on 28/09/2017.
 */

public interface ITeamHandler extends IFailureCallback {

    void OnGetTeam(Team team);
}
