package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    val explorer: List<String>?,
    val facebook: List<String>?,
    val reddit: List<String>?,
    @Json(name = "source_code")
    val sourceCode: List<String>?,
    val website: List<String>?,
    val youtube: List<String>?,
)
