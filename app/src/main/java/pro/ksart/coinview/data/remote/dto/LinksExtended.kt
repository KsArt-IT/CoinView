package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksExtended(
    val stats: Stats?,
    val type: String,
    val url: String,
)
