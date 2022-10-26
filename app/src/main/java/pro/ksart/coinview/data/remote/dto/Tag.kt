package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "coin_counter")
    val coinCounter: Int,
    @Json(name = "ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)
