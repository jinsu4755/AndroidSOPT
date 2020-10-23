package com.sopt_27.firstseminarequiretask1.data

import android.app.Activity
import android.content.Context

class AuthShardPreferenceRepository private constructor(context: Context) {

    private val shardPreference =
        context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)

    private val editor = shardPreference.edit()

    val user_id: String?
        get() = shardPreference.getString(AUTH_SHARD_PREF+"_ID", null)

    val user_password: String?
        get() = shardPreference.getString(AUTH_SHARD_PREF + "_PW", null)

    fun saveUserId(id: String) {
        editor.putString(AUTH_SHARD_PREF+"_ID",id).apply()
    }

    fun saveUserPassword(password: String) {
        editor.putString(AUTH_SHARD_PREF + "_PW", password).apply()
    }

    fun removeUserId() {
        editor.remove(AUTH_SHARD_PREF + "_ID")
    }

    fun removeUserPassword(){
        editor.remove(AUTH_SHARD_PREF + "_PW")
    }

    fun haveUserIdAndUserPassword(): Boolean {
        return !user_id.isNullOrBlank() && !user_password.isNullOrBlank()
    }


    companion object {

        const val AUTH_SHARD_PREF: String = "SOPT_Auth"

        @Volatile
        private var instance: AuthShardPreferenceRepository? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: AuthShardPreferenceRepository(context).apply {
                instance = this
            }
        }
    }
}