package net.tecgurus.mobilepos.controllers.repository;

import android.app.Activity;

import net.tecgurus.mobilepos.controllers.db.AppDatabase;

public class Repository {
    protected AppDatabase appDatabase;
    protected Activity activity;

    private Repository(){
            }
    protected  Repository(final Activity activity){
        this.activity= activity;
        appDatabase= AppDatabase.getAppDatabase(activity);
    }
}
