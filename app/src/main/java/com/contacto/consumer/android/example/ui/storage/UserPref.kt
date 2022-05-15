package com.contacto.consumer.android.example.ui.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class UserPref {

    companion object {

        fun savePref(context: Context, appId: String, appKey: String) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("ContacctoPref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("APP_ID", appId)
            editor.putString("APP_KEY", appKey)
            editor.apply()
        }

        fun getAppKey(context: Context): String? {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("ContacctoPref", MODE_PRIVATE)
            return sharedPreferences.getString("APP_KEY", null)
        }

        fun getAppId(context: Context): String? {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences("ContacctoPref", MODE_PRIVATE)
            return sharedPreferences.getString("APP_ID", null)
        }
    }
}