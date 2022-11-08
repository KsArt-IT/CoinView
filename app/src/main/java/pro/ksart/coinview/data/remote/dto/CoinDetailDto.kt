package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pro.ksart.coinview.domain.entities.CoinDetail

@JsonClass(generateAdapter = true)
data class CoinDetailDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @Json(name = "is_new")
    val isNew: Boolean,
    @Json(name = "is_active")
    val isActive: Boolean,
    val type: String?,
    val contract: String?,
    val logo: String?,
    val platform: String?,
    val description: String,
    @Json(name = "development_status")
    val developmentStatus: String?,
    @Json(name = "first_data_at")
    val firstDataAt: String?,
    @Json(name = "hardware_wallet")
    val hardwareWallet: Boolean,
    @Json(name = "hash_algorithm")
    val hashAlgorithm: String?,
    @Json(name = "last_data_at")
    val lastDataAt: String?,
    val links: Links,
    @Json(name = "links_extended")
    val linksExtended: List<LinksExtended>,
    val message: String?,
    @Json(name = "open_source")
    val openSource: Boolean,
    @Json(name = "org_structure")
    val orgStructure: String?,
    @Json(name = "proof_type")
    val proofType: String?,
    @Json(name = "started_at")
    val startedAt: String?,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        logo = logo,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}
