package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    val contributors: Int?,
    val followers: Int?,
    val stars: Int?,
    val subscribers: Int?,
    val members: Int?,
)
