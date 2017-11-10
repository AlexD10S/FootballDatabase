package alexd10s.com.footballdatabase.model;

/**
 * Created by alex on 28/09/2017.
 */

public class Links {
    private LinksAux self;
    private LinksAux fixtures;
    private LinksAux players;


    public LinksAux getSelf() {
        return self;
    }

    public void setSelf(LinksAux self) {
        this.self = self;
    }

    public LinksAux getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinksAux fixtures) {
        this.fixtures = fixtures;
    }

    public LinksAux getPlayers() {
        return players;
    }

    public void setPlayers(LinksAux players) {
        this.players = players;
    }
}
