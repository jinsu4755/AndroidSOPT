package sopt.onsopt.semina.domain.home

data class PortfolioDomain(
    val full_name:String,
    val description:String,
    val html_url:String,
    val owner:Owner
)

data class Owner(
    val avatar_url:String
)
