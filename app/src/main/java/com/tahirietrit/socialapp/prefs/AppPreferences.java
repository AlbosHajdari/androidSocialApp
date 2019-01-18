package com.tahirietrit.socialapp.prefs;
import android.content.Context;
import android.content.SharedPreferences;
public class AppPreferences {
    private static final String PREFS_KEY = "user_preferences";
    private static final String USERID_KEY = "user_id";
    private static final String USERNAME_KEY = "username_preferences";

    private static SharedPreferences preferences;

    public static void init(Context ctx){
        preferences = ctx.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
    }

    public static void saveUserID(String userId){
        preferences.edit().putString(USERID_KEY,userId).apply();
    }
    public static void saveUserName(String userName){
        preferences.edit().putString(USERID_KEY,userName).apply();
    }

    public static String getUserID(){return preferences.getString(USERID_KEY, null);}
    public static String getUserName(){return preferences.getString(USERNAME_KEY, null);}

}
