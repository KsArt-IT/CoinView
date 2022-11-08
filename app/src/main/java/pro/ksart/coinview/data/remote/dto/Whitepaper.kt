package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Whitepaper(
    val link: String?,
    val thumbnail: String?
)
