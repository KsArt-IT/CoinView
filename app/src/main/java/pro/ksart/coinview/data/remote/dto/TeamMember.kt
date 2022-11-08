package pro.ksart.coinview.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)
