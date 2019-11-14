package com.example.coderscal;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {
    private SharedPreferences sp;
    private Context context;

    public SharedPreferenceConfig(Context context){
        this.context=context;
        sp=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status,String user){
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.putString(context.getResources().getString(R.string.login_preference),user);

        editor.putBoolean("com.example.coderscal_listcc",true);
        editor.putBoolean("com.example.coderscal_listcf",true);
        editor.putBoolean("com.example.coderscal_listtop",true);
        editor.putBoolean("com.example.coderscal_listhe",true);
        editor.putBoolean("com.example.coderscal_listhr",true);
        editor.putBoolean("com.example.coderscal_listothers",false);

        if(!user.equals("")) {
            DataBase db = new DataBase(context);
            String cc = db.getcc(user);
            String cf = db.getcf(user);
            String top = db.gettop(user);
            String he = db.gethe(user);
            String hr = db.gethr(user);
            editor.putString(context.getResources().getString(R.string.login_ccuser), cc);
            editor.putString(context.getResources().getString(R.string.login_cfuser), cf);
            editor.putString(context.getResources().getString(R.string.login_topuser), top);
            editor.putString(context.getResources().getString(R.string.login_heuser), he);
            editor.putString(context.getResources().getString(R.string.login_hruser), hr);
            db.close();
        }
        editor.commit();
    }

    public boolean readLoginStatus(){
        boolean status=false;
        status=sp.getBoolean(context.getResources().getString(R.string.login_status_preference),false);
        return status;
    }

    public String readUser(){
        String user="";
        user=sp.getString("com.example.coderscal_login_preference","");
        return user;
    }

    public String readcc(){
        String cc="";
        cc=sp.getString("com.example.coderscal_login_ccuser","");
        return cc;
    }
    public String readcf(){
        String cf="";
        cf=sp.getString("com.example.coderscal_login_cfuser","");
        return cf;
    }
    public String readtop(){
        String top="";
        top=sp.getString("com.example.coderscal_login_topuser","");
        return top;
    }
    public String readhe(){
        String he="";
        he=sp.getString("com.example.coderscal_login_heuser","");
        return he;
    }
    public String readhr(){
        String hr="";
        hr=sp.getString("com.example.coderscal_login_hruser","");
        return hr;
    }
}
