package com.galaxy.myapplication;

import android.app.Application;

import com.galaxy.myapplication.model.DaoMaster;
import com.galaxy.myapplication.model.DaoSession;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

/**
 * Created by Alumno on 15/10/2017.
 */

public class SesionDAO extends Application{

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this,"mydb");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
