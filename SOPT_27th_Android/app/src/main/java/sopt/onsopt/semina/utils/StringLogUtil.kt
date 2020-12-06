package sopt.onsopt.semina.utils

import android.text.TextUtils
import android.util.Log

fun loggingDebug(vararg logMessages:String) {
    val logMessage = TextUtils.join("\n", logMessages)
    Log.d("jinsu4755:DEBUG",logMessage)
}