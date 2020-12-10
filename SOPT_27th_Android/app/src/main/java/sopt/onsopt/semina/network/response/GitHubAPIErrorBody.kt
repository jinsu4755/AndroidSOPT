/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubAPIErrorBody(
    val message: String
)