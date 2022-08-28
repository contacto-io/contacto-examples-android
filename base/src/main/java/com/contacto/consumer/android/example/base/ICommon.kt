package com.contacto.consumer.android.example.base

interface ICommon {

    fun savePref(appId: String, appKey: String)
    fun getAppKey(): String?
    fun getAppId(): String?
    fun saveUser(fName: String, lName: String, email: String, phone: String)
    fun getFirstName(): String?
    fun getLastName(): String?
    fun getEmail(): String?
    fun getPhone(): String?

}