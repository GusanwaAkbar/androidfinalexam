package com.example.mgafinalexam.utils

import android.content.Context
import android.content.SharedPreferences

object PrefManager {
    private const val PREF_NAME = "my_prefs"

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(context: Context, token: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getToken(context: Context): String? {
        return getSharedPreferences(context).getString("token", null)
    }

    fun deleteToken(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove("token")
        editor.apply()
    }
}
