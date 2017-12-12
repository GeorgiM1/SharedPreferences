package com.example.android.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by pc on 12/12/2017.
 */

public class PreferencesMenager {

    private static SharedPreferences getPreferences (Context context){
        return  context.getApplicationContext().getSharedPreferences("MySharedPreferencesFile", Activity.MODE_PRIVATE);
    }

    public static String getFirstName (Context c){
        return  getPreferences(c).getString("firstname","no name");
    }
    public static void setFirstName (Context context,String firstName){
        getPreferences(context).edit().putString("firstname", firstName).apply();
    }
    public  static String getLastname (Context context){
        return getPreferences(context).getString("lastname", "no lastname");

    }

    public static void setLastname (Context context, String lastname) {
        getPreferences(context).edit().putString("lastname", lastname).apply();
    }
    public  static  String getAge (Context context){
        return getPreferences(context).getString("age", "0");
    }

    public static void setAge (Context context, String age){
        getPreferences(context).edit().putString("age", age).apply();
    }
    public static boolean getSex (Context context){
        return getPreferences(context).getBoolean("is checked", true);
    }
    public static void setSex (Context context, boolean b){
        getPreferences(context).edit().putBoolean("is checked", b).apply();
    }

    public static void  addUser(User shopModel, Context c){
        Gson gson = new Gson();
        String mapStrnig = gson.toJson(shopModel);
        getPreferences(c).edit().putString("user", mapStrnig).notifyAll();
    }
    public static  User getUser (Context context){
        //ListPrefs();
        return  new Gson().fromJson(getPreferences(context).getString("user", ""), User.class);
    }
}
