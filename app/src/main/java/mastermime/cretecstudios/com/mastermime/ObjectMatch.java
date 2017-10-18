package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vinicios-biluca on 16/10/17.
 */

@Entity
public class ObjectMatch {

    @Id
    Long id;

    @Property
    double turn;

    @Property
    double time;

    @Property
    double turns;

    @Property
    double pts_team1;

    @Property
    double pts_team2;

    @Property
    String team1;

    @Property
    String team2;

    @Generated(hash = 335681485)
    public ObjectMatch(Long id, double turn, double time, double turns,
            double pts_team1, double pts_team2, String team1, String team2) {
        this.id = id;
        this.turn = turn;
        this.time = time;
        this.turns = turns;
        this.pts_team1 = pts_team1;
        this.pts_team2 = pts_team2;
        this.team1 = team1;
        this.team2 = team2;
    }

    @Generated(hash = 203654267)
    public ObjectMatch() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTurn() {
        return this.turn;
    }

    public void setTurn(double turn) {
        this.turn = turn;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTurns() {
        return this.turns;
    }

    public void setTurns(double turns) {
        this.turns = turns;
    }

    public double getPts_team1() {
        return this.pts_team1;
    }

    public void setPts_team1(double pts_team1) {
        this.pts_team1 = pts_team1;
    }

    public double getPts_team2() {
        return this.pts_team2;
    }

    public void setPts_team2(double pts_team2) {
        this.pts_team2 = pts_team2;
    }

    public String getTeam1() {
        return this.team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return this.team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }


}
