/*
 * Created By: jinsu4755
 * on 2020.12.8
 */
package sopt.onsopt.semina.network

import retrofit2.Call
import retrofit2.http.GET
import sopt.onsopt.semina.network.response.PortfolioDTO
import sopt.onsopt.semina.network.response.ProfileDTO

interface GitHubService {

    @GET("/users/jinsu4755")
    fun requestMyGitHubProfile():Call<ProfileDTO>

    @GET("/users/jinsu4755/repos")
    fun requestMyGitHubRepository():Call<List<PortfolioDTO>>

    companion object {
        private const val BASE_URL = "https://api.github.com"

        @Volatile
        private var instance: GitHubService? = null

        fun getInstance(): GitHubService = instance ?: synchronized(this) {
            instance ?: provideService(GitHubService::class.java, BASE_URL)
                .apply { instance = this }
        }
    }
}