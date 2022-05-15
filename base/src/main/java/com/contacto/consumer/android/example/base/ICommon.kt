package com.contacto.consumer.android.example.base

import android.content.Context

interface ICommon {

    fun savePref(appId: String, appKey: String)
    fun getAppKey(): String?
    fun getAppId(): String?

}