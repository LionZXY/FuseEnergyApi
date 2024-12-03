package uk.kulikov.api.model.stats.chart

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.kulikov.api.model.stats.chart.column.ChartDelta
import uk.kulikov.api.model.stats.chart.column.LocalDateTimeJsonModel

@Serializable
data class ChartColumn(
    @SerialName("delta") val delta: ChartDelta,
    @SerialName("index") val index: LocalDateTimeJsonModel
)