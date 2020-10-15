package com.antilog.semina_1st_plustask2

import android.content.Context
import android.content.SharedPreferences

class SaveSharedPreferences(context: Context) {
    val FILENAME = "prefs_data"
    val SAVE_ID = "userId"
    val SAVE_PW = "userPw"

    /* context.getPreferences의 SharedPreferences 인스턴스를 저장.
    * (0은 (Context.MODE_PRIVATE)와 같음)
    * 에디터를 호출해 editor로 초기화. */
    val preferences: SharedPreferences = context.getSharedPreferences(FILENAME, 0)


    //user의 Id를 저장하는
    var userId : String?
    get() = preferences.getString(SAVE_ID, "")
    set(value) = preferences.edit().putString(SAVE_ID, value).apply()
    /*get&set 함수 임의 설정.
    * get: 실행시 저장된 값을 반환하고 default 값은 "" 이다
    * set: 실행시 value로 값을 대체하고 저장시킨다.*/

    var userPw: String?
    get() = preferences.getString(SAVE_PW,"")
    set(value) = preferences.edit().putString(SAVE_PW, value).apply()
}