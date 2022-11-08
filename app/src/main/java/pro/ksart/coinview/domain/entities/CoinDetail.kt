package pro.ksart.coinview.domain.entities

import pro.ksart.coinview.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val logo: String?,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
