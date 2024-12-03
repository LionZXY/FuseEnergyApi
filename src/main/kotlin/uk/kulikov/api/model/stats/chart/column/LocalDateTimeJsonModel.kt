package uk.kulikov.api.model.stats.chart.column

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalDateTimeJsonModel(
    @SerialName("year")
    val year: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("day")
    val day: Int,
    @SerialName("hour")
    val hour: Int
)