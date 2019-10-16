package com.androidapplication.maps;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.inputmethod.InputMethodManager;

/**
 * this class is used commonly in whole app for some reusable common functions/methods
 */
public class Utils {

    private static Utils utils;
    private static AlertDialog dialog;

    public static Utils getInstance() {
        if (utils == null)
            utils = new Utils();
        return utils;
    }

    public static void hideKeyBoardwithinput(Activity activity) {
        try {

            InputMethodManager inputMethodManager = ((InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE));
            inputMethodManager.hideSoftInputFromWindow(activity
                    .getCurrentFocus().getWindowToken(), 0);

        } catch (Exception e) {
        }
    }



    /**
     * Function that checks if network is available
     *
     * @param context passed by calling activity
     * @return true if network is available, false if not
     */
    public boolean isNetworkAvailable(final Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        return false;
    }





}