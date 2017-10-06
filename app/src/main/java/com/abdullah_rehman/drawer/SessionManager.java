package com.abdullah_rehman.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Abdullah_Rehman on 05-Oct-17.
 */

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;


    // Editor for Shared preferences
    SharedPreferences.Editor editor;


    // Context
    Context _context;

    // Temp Context
    Context _tempContext;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "BloodDonation";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    // TEMP login status
//    private static final String IS_TEMP_LOGIN = "IsLoggedIn";

//
//    public static final String KEY_USER_ID = "user_id";
//    public static final String KEY_NAME = "full_name";
//    public static final String KEY_GENDER = "gender";
//    public static final String KEY_AGE = "age";
//    public static final String KEY_BLOOD_GROUP = "blood_group";
//    public static final String KEY_CONTACT_NUMBER = "contact_no";
//    public static final String KEY_CITY = "city";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
//    public static final String KEY_THANKS = "thanks";
//    public static final String KEY_LAST_DONATION = "last_donation_data";
//    public static final String KEY_REG_DATE = "reg_date";
//    private String username;


    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

//    public void setUserName(String user){
//        editor.putString("USER",user);
//        editor.commit();
//    }
//    public String getUserName(){
//        String user=pref.getString("USER",null);
//        return user;
//    }

    /**
     * Create login session
     * */
    public void createLoginSession(String email, String password){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);

        // commit changes
        editor.commit();

        Intent i = new Intent(_context, MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



        // Staring Login Activity
        _context.startActivity(i);

    }

//    /**
//     * Check login method wil check user login status
//     * If false it will redirect user to login page
//     * Else won't do anything
//     * */
//    public void checkLogin(){
//        // Check login status
//        if(!this.isLoggedIn()){
//            Log.v("URL", "User Is not logged in");
//            Toast.makeText(_context, "Please login First!", Toast.LENGTH_SHORT).show();
//            // user is not logged in redirect him to Login Activity
//            Intent i = new Intent(this._context, BaseActivity.class);
//            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            // Add new Flag to start new Activity
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            // Staring Login Activity
//            this._context.startActivity(i);
//            //return false;
//        }else {
//            Log.v("URL", "User Is logged in");
//            //return true;
//        }
//
//    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
//        FacebookSdk.sdkInitialize(_context);
//        LoginManager.getInstance().logOut();
//        disconnectFromFacebook();

        Log.e("@@@@@@@@@@@", "Log out......");
        // After logout redirect user to Login Activity
        Intent i = new Intent(_context, BaseActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



        // Staring Login Activity
        _context.startActivity(i);
    }

    public boolean isLoggedIn(){

        return pref.getBoolean(IS_LOGIN, false);
        //return true;
    }
}