package uk.kulikov.api.model.stats

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatsPagination(
    @SerialName("previous_index") val previousIndex: LocalDateJsonModel? = null,
    @SerialName("current_index") val currentIndex: LocalDateJsonModel? = null,
    @SerialName("next_index") val nextIndex: LocalDateJsonModel? = null
)