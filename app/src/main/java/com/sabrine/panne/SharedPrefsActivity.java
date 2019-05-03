package com.sabrine.panne;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "login";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_IS_LOGIN = "isLogin";

    // Constructor
    @SuppressLint("CommitPrefEdits")
    public SharedPrefsActivity(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //save user name to SharedPref
    public void setSavedIdName(String userID) {
        editor.putString(KEY_USER_ID, userID);
        editor.commit();
    }

    //retrieve username frome pref
    public String getSavedUserID() {
        return pref.getString(KEY_USER_ID, "");
    }


    public boolean isUserLogin() {
        return pref.getBoolean(KEY_IS_LOGIN, false);
    }

    public void setUserLoggedIn(boolean isLogin) {
        editor.putBoolean(KEY_IS_LOGIN, isLogin);
        editor.commit();
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }
}
