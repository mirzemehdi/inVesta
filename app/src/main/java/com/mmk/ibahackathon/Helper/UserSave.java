package com.mmk.ibahackathon.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.mmk.ibahackathon.Utils.Common;

public class UserSave {
    private Context context;
    private static  SharedPreferences sharedPreferences;


    public static void saveUser(Context context){
        init(context);
        sharedPreferences.edit().putBoolean(Common.KEY_IS_USER_LOGIN,true)
                .apply();
    }

    private static void init(Context context) {
        sharedPreferences=context.getSharedPreferences(Common.SHARED_PREFERENCE_USER,Context.MODE_PRIVATE);
    }

    public static boolean isLogedIn(Context context){
        init(context);
        return sharedPreferences.getBoolean(Common.KEY_IS_USER_LOGIN,false);
    }
    public static void removeUser(Context context){
        init(context);
        sharedPreferences.edit().clear().apply();
    }

}
