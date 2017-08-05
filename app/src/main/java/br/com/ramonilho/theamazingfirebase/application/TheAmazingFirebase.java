package br.com.ramonilho.theamazingfirebase.application;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by logonrm on 05/08/2017.
 */

public class TheAmazingFirebase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Crashlytics
        Fabric.with(this, new Crashlytics());
        Crashlytics.setUserName("13MobTestUser"); // just to appear in Crashlytics session
    }
}
