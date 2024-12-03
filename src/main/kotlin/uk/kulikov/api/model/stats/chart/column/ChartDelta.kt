package uk.kulikov.api.model.stats.chart.column

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.kulikov.api.model.stats.chart.column.delta.ChartConsumption

@Serializable
data class ChartDelta(
    @SerialName("consumption") val consumption: ChartConsumption
)