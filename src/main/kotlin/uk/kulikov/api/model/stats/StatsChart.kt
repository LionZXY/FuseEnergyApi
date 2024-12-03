package uk.kulikov.api.model.stats

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.kulikov.api.model.stats.chart.ChartColumn

@Serializable
data class StatsChart(
    @SerialName("columns") val columns: List<ChartColumn>,
    @SerialName("readings_count") val readingsCount: ReadingsCount
)