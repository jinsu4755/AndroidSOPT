/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.network.request

import retrofit2.Call
import sopt.onsopt.semina.network.GitHubService
import sopt.onsopt.semina.network.response.PortfolioDTO

class GitPortfolioRequest: BaseRequest<List<PortfolioDTO>>() {
    override fun createCall(): Call<List<PortfolioDTO>> {
        return GitHubService.getInstance()
            .requestMyGitHubRepository()
    }
}