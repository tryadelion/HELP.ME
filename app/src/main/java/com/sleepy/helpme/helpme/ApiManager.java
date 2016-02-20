package com.sleepy.helpme.helpme;

import android.content.Context;

/**
 * Created by cpteric on 20/02/16.
 */
public class ApiManager {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ApiManager.context = context;
    }
}
