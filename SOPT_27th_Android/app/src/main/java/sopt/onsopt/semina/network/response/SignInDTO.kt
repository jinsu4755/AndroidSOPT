/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.network.response

import com.squareup.moshi.JsonClass
import sopt.onsopt.semina.domain.user.SignUpDomain

@JsonClass(generateAdapter = true)
data class SignInDTO(
    val email: String,
    val password:String,
    val userName: String,
) {
    fun asDomainModel(): SignUpDomain {
        return SignUpDomain(
            email = email,
            password = password,
            userName = userName
        )
    }
}