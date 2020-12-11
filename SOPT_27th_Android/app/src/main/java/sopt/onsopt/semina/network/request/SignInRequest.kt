/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.network.request

import retrofit2.Call
import sopt.onsopt.semina.domain.user.SignInDomain
import sopt.onsopt.semina.network.SOPTService
import sopt.onsopt.semina.network.response.BaseResponse
import sopt.onsopt.semina.network.response.SignInDTO

class SignInRequest(
    private val signInDomain: SignInDomain
): SOPTBaseRequest<SignInDTO>() {
    override fun createCall(): Call<BaseResponse<SignInDTO>> {
        return SOPTService.getInstance()
            .requestSignIn(
                signInData = signInDomain
            )
    }
}