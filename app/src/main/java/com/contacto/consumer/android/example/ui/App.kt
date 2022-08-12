package com.contacto.consumer.android.example.ui

import android.app.Application
import android.content.SharedPreferences

class App : Application(), com.contacto.consumer.android.example.base.ICommon {

    override fun savePref(appId: String, appKey: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("APP_ID", appId)
        editor.putString("APP_KEY", appKey)
        editor.apply()
    }

    override fun getAppKey(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("APP_KEY", null)
    }

    override fun getAppId(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("APP_ID", null)
    }

    override fun saveUser(fName: String, lName: String, email: String, phone: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("FIRST_NAME", fName)
        editor.putString("LAST_NAME", lName)
        editor.putString("EMAIL", email)
        editor.putString("PHONE", phone)
        editor.apply()
    }

    override fun getFirstName(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("FIRST_NAME", null)
    }

    override fun getLastName(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("LAST_NAME", null)
    }

    override fun getEmail(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("EMAIL", null)
    }

    override fun getPhone(): String? {
        val sharedPreferences: SharedPreferences = getSharedPreferences("ContacctoPref", MODE_PRIVATE)
        return sharedPreferences.getString("PHONE", null)
    }
}