/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.network.request

import retrofit2.Call
import sopt.onsopt.semina.network.GitHubService
import sopt.onsopt.semina.network.response.ProfileDTO

class GitProfileRequest() : BaseRequest<ProfileDTO>() {
    override fun createCall(): Call<ProfileDTO> {
        return GitHubService.getInstance()
            .requestMyGitHubProfile()
    }
}