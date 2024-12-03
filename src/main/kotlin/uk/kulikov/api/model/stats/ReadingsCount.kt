package uk.kulikov.api.model.stats

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadingsCount(
    @SerialName("completed") val completed: Int,
    @SerialName("total") val total: Int,
)