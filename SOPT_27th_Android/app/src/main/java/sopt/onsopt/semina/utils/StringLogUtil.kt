package sopt.onsopt.semina.utils

import android.text.TextUtils
import android.util.Log

fun loggingDebug(
    loggingTag:String?,
    vararg logMessages:String) {
    val logMessage = TextUtils.join("\n", logMessages)
    Log.d(loggingTag?:"jinsu4755:DEBUG",logMessage)
}