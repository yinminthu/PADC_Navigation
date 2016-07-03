package xyz.phyoeyinminthu.padc_navigationview;

import android.app.Application;
import android.content.Context;

/**
 * Created by user01 on 7/1/2016.
 */
public class NavigationViewApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
