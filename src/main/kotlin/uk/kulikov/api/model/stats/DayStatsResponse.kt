package uk.kulikov.api.model.stats

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayStatsResponse(
    @SerialName("pagination")
    val pagination: StatsPagination,
    @SerialName("chart")
    val charts: StatsChart,
)