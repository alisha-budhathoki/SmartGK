package com.example.smartgk.utitlies;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass {
    Context context;
    SharedPreferences sp;

    public SharedPreferenceClass(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("UserDetail",Context.MODE_PRIVATE);
    }

    public void saveData(String u_id,String name,String email,String pic, String bio){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("u_id",u_id);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("pic",pic);
        editor.putString("bio", bio);
        editor.apply();
    }



    public void isLooggedIn(boolean login){
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLoogedIn",login);
        editor.apply();
    }


    public boolean isLoggedIn(){
        return sp.getBoolean("isLoogedIn",false);
    }

    public String getName(){
        return sp.getString("name","");
    }

    public String getEmail(){
        return sp.getString("email","");
    }

    public String getPic(){
        return sp.getString("pic","");
    }

    public String getUid(){
        return sp.getString("u_id","");
    }

    public String getBio(){ return sp.getString("bio", "");}


}
