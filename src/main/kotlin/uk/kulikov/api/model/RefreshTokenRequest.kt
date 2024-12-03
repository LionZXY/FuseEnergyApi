package uk.kulikov.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("original_request_path")
    val originalRequestPath: String = "https://api.fuseenergy.com/api/v1/notifications/activity-centre/unread-count"
)