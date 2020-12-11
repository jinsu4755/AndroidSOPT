/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.network.request

import retrofit2.Call
import sopt.onsopt.semina.domain.user.SignUpDomain
import sopt.onsopt.semina.network.SOPTService
import sopt.onsopt.semina.network.response.BaseResponse
import sopt.onsopt.semina.network.response.SignUpDTO

class SignUpRequest(
    private val signUpDomain: SignUpDomain
): SOPTBaseRequest<SignUpDTO>() {
    override fun createCall(): Call<BaseResponse<SignUpDTO>> {
        return SOPTService.getInstance()
            .requestSignUp(
                signUpData = signUpDomain
            )
    }
}