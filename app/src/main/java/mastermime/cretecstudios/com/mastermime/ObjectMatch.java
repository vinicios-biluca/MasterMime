package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vinicios-biluca on 29/09/17.
 */

@Entity
public class ObjectMatch {

    @Id
    Long id;

    @Property
    double turns;

    @Property
    double time;

    @Generated(hash = 238222803)
    public ObjectMatch(Long id, double turns, double time) {
        this.id = id;
        this.turns = turns;
        this.time = time;
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

    public double getTurns() {
        return this.turns;
    }

    public void setTurns(double turns) {
        this.turns = turns;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

}
