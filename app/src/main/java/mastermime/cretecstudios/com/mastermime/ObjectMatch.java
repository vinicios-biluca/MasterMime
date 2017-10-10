package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by vinicios-biluca on 29/09/17.
 */

@Entity
public class ObjectMatch {

    @Id
    private long id;

    private long team1Id, team2Id;

    @ToOne(joinProperty="team1Id")
    private ObjectTeam team1;

    @ToOne(joinProperty="team2Id")
    private ObjectTeam team2;

    int team1_points, team2_points;
    int turns, time;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1671652387)
    private transient ObjectMatchDao myDao;
    @Generated(hash = 1229064024)
    public ObjectMatch(long id, long team1Id, long team2Id, int team1_points,
            int team2_points, int turns, int time) {
        this.id = id;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.team1_points = team1_points;
        this.team2_points = team2_points;
        this.turns = turns;
        this.time = time;
    }
    @Generated(hash = 203654267)
    public ObjectMatch() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTeam1Id() {
        return this.team1Id;
    }
    public void setTeam1Id(long team1Id) {
        this.team1Id = team1Id;
    }
    public long getTeam2Id() {
        return this.team2Id;
    }
    public void setTeam2Id(long team2Id) {
        this.team2Id = team2Id;
    }
    public int getTeam1_points() {
        return this.team1_points;
    }
    public void setTeam1_points(int team1_points) {
        this.team1_points = team1_points;
    }
    public int getTeam2_points() {
        return this.team2_points;
    }
    public void setTeam2_points(int team2_points) {
        this.team2_points = team2_points;
    }
    public int getTurns() {
        return this.turns;
    }
    public void setTurns(int turns) {
        this.turns = turns;
    }
    public int getTime() {
        return this.time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    @Generated(hash = 754364378)
    private transient Long team1__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 395820807)
    public ObjectTeam getTeam1() {
        long __key = this.team1Id;
        if (team1__resolvedKey == null || !team1__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ObjectTeamDao targetDao = daoSession.getObjectTeamDao();
            ObjectTeam team1New = targetDao.load(__key);
            synchronized (this) {
                team1 = team1New;
                team1__resolvedKey = __key;
            }
        }
        return team1;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1575512360)
    public void setTeam1(@NotNull ObjectTeam team1) {
        if (team1 == null) {
            throw new DaoException(
                    "To-one property 'team1Id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team1 = team1;
            team1Id = team1.getId();
            team1__resolvedKey = team1Id;
        }
    }
    @Generated(hash = 1875642404)
    private transient Long team2__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1258317518)
    public ObjectTeam getTeam2() {
        long __key = this.team2Id;
        if (team2__resolvedKey == null || !team2__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ObjectTeamDao targetDao = daoSession.getObjectTeamDao();
            ObjectTeam team2New = targetDao.load(__key);
            synchronized (this) {
                team2 = team2New;
                team2__resolvedKey = __key;
            }
        }
        return team2;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 288884446)
    public void setTeam2(@NotNull ObjectTeam team2) {
        if (team2 == null) {
            throw new DaoException(
                    "To-one property 'team2Id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team2 = team2;
            team2Id = team2.getId();
            team2__resolvedKey = team2Id;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 572618197)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getObjectMatchDao() : null;
    }


}
