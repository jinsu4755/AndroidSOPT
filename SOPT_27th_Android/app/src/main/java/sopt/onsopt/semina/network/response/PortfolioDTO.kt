/*
 * Created By: jinsu4755
 * on 2020.12.9
 */

package sopt.onsopt.semina.network.response

import com.squareup.moshi.JsonClass
import sopt.onsopt.semina.domain.home.OwnerDomain
import sopt.onsopt.semina.domain.home.PortfolioDomain

@JsonClass(generateAdapter = true)
data class PortfolioDTO(
    val full_name: String,
    val description: String?,
    val html_url: String,
    val owner: OwnerDTO
) {
    fun asDomainModel():PortfolioDomain = PortfolioDomain(
        full_name = this.full_name,
        description = this.description,
        html_url = this.html_url,
        owner = this.owner.asDomainModel()
    )

}

@JsonClass(generateAdapter = true)
data class OwnerDTO(
    val avatar_url: String
){
    fun asDomainModel():OwnerDomain = OwnerDomain(avatar_url)
}