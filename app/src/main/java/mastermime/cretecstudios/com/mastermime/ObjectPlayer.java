package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.ArrayList;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by vinicios-biluca on 29/09/17.
 */

@Entity
public class ObjectPlayer {

    @Id
    private long code;

    private long objectTeamId;

    @ToOne(joinProperty = "objectTeamId")
    private ObjectTeam team;

    @Unique
    private String name;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 999492986)
    private transient ObjectPlayerDao myDao;

    @Generated(hash = 424329357)
    public ObjectPlayer(long code, long objectTeamId, String name) {
        this.code = code;
        this.objectTeamId = objectTeamId;
        this.name = name;
    }

    @Generated(hash = 904672753)
    public ObjectPlayer() {
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getObjectTeamId() {
        return this.objectTeamId;
    }

    public void setObjectTeamId(long objectTeamId) {
        this.objectTeamId = objectTeamId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Generated(hash = 1834174654)
    private transient Long team__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1849410109)
    public ObjectTeam getTeam() {
        long __key = this.objectTeamId;
        if (team__resolvedKey == null || !team__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ObjectTeamDao targetDao = daoSession.getObjectTeamDao();
            ObjectTeam teamNew = targetDao.load(__key);
            synchronized (this) {
                team = teamNew;
                team__resolvedKey = __key;
            }
        }
        return team;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2121760915)
    public void setTeam(@NotNull ObjectTeam team) {
        if (team == null) {
            throw new DaoException(
                    "To-one property 'objectTeamId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team = team;
            objectTeamId = team.getId();
            team__resolvedKey = objectTeamId;
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
    @Generated(hash = 1732164980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getObjectPlayerDao() : null;
    }

/*    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }
    */

}
