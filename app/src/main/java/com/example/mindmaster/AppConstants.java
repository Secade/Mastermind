package com.example.mindmaster;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int numberOfCommittees;
    static Context gameActivityContext;

    public static void initialization(Context context){
        setScreenSize(context);
        setGameConstants();
    }

    public static void setGameConstants(){
        AppConstants.numberOfCommittees = 12;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }
}
