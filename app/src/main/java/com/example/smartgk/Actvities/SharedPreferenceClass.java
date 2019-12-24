package com.example.smartgk.Actvities;

import android.content.Context;
import android.content.SharedPreferences;

class SharedPreferenceClass {
    Context context;
    SharedPreferences sp;

    public SharedPreferenceClass(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("UserDetail",Context.MODE_PRIVATE);
    }

    public void saveData(String u_id,String name,String email,String pic){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("u_id",u_id);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("pic",pic);
        editor.apply();
    }
    public void isLooggedIn(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLoogedIn",true);
        editor.apply();
    }

    public boolean isLoggedIn(){
        return sp.getBoolean("isLoogedIn",false);
    }
}
