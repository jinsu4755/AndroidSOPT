/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.network.request

import android.text.TextUtils
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.onsopt.semina.network.GitHubService
import sopt.onsopt.semina.network.moshi
import sopt.onsopt.semina.network.response.BaseResponse
import sopt.onsopt.semina.network.response.GitHubAPIErrorBody
import sopt.onsopt.semina.network.response.ProfileDTO
import sopt.onsopt.semina.utils.loggingDebug

abstract class SOPTBaseRequest<RESPONSE> : Callback<BaseResponse<RESPONSE>> {

    private var onSuccessListener: ((BaseResponse<RESPONSE>) -> Unit)? = null
    private var onErrorListener: ((String?) -> Unit)? = null
    private var onFailureListener: (() -> Unit)? = null

    fun setOnSuccessListener(listener: (BaseResponse<RESPONSE>) -> Unit) {
        this.onSuccessListener = listener
    }

    fun setOnErrorListener(listener: (String?) -> Unit) {
        this.onErrorListener = listener
    }

    fun setOnFailureListener(listener: () -> Unit) {
        this.onFailureListener = listener
    }

    fun send() {
        createCall().enqueue(this)
    }

    protected abstract fun createCall(): Call<BaseResponse<RESPONSE>>

    override fun onResponse(call: Call<BaseResponse<RESPONSE>>, response: Response<BaseResponse<RESPONSE>>) {
        if (response.isSuccessful) {
            onSuccessListener?.invoke(response.body() ?: return)
            return
        }
        val errorBody = response.errorBody() ?: return
        val errorMessage = createErrorBody(errorBody)?.message
        onErrorListener?.invoke(errorMessage)
    }

    private fun createErrorBody(errorBody: ResponseBody): GitHubAPIErrorBody? {
        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return moshi.adapter(GitHubAPIErrorBody::class.java).fromJson(errorBody.source())
    }

    override fun onFailure(call: Call<BaseResponse<RESPONSE>>, t: Throwable) {
        logFailureMessage(t)
        onFailureListener?.invoke()
    }

    private fun logFailureMessage(t: Throwable) {
        Log.d(SERVER_ERROR_TAG, "${t.message}\n")
        Log.d(SERVER_ERROR_TAG, "${t.localizedMessage}\n")
        Log.d(SERVER_ERROR_TAG, TextUtils.join("\n", t.stackTrace))
    }

    companion object {
        private const val SERVER_ERROR_TAG = "SERVER_ERROR_MESSAGE"
    }
}