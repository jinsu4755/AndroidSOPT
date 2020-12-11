/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.network.response

data class BaseResponse<T>(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: T
)
