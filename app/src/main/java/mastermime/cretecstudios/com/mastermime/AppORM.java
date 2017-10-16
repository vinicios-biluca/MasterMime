package mastermime.cretecstudios.com.mastermime;

import android.app.Application;

import org.greenrobot.greendao.database.Database;


public class AppORM extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mastermime-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        daoSession.clear();
    }

    public DaoSession getDaoSession() {

        return daoSession;

    }
}