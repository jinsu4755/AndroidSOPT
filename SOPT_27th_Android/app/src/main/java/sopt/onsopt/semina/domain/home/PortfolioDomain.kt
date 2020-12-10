package sopt.onsopt.semina.domain.home

data class PortfolioDomain(
    val full_name:String,
    val description: String?,
    val html_url:String,
    val owner:OwnerDomain
)

data class OwnerDomain(
    val avatar_url:String
)
