/*
 * Created By: jinsu4755
 * on 2020.12.9
 */

package sopt.onsopt.semina.network.response

import com.squareup.moshi.JsonClass
import sopt.onsopt.semina.domain.profile.ProfileDomain

@JsonClass(generateAdapter = true)
data class ProfileDTO(
    val login:String,
    val avatar_url:String,
    val bio:String,
    val blog:String,
){
    fun asDomainModel() : ProfileDomain = ProfileDomain(
        login = this.login,
        avatar_url = this.avatar_url,
        bio = this.bio,
        blog = this.blog
    )
}