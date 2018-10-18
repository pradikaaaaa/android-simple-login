package com.example.user.week07ti3cyahya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by user on 16/10/2018.
 */

public class SessionManagement {
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;

    private Context mContext;

    int PRIVATE_MODE;
    private static final String PREF_NAME = "SharedPrefLogin";
    private  static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAMA = "nama";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    public void createLoginSession(String username, String nama){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_USERNAME,username);
        mEditor.putString(KEY_NAMA,nama);

        mEditor.commit();
    }


    public boolean isLoggedIn(){
        return  mSharedPreference.getBoolean(IS_LOGIN,false);
    }

    public void checkIsLogin(){
        if(!isLoggedIn()){
            Intent i = new Intent(mContext, MainActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();

        Intent i = new Intent(mContext,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }

    public String getNama(){
        return mSharedPreference.getString("nama",null);
    }

}
