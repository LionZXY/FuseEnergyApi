package uk.kulikov.api.model.stats.chart.column.delta

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChartUsage(
    @SerialName("money") val money: ChartMoney?,
    @SerialName("kWh") val kWh: String,
    @SerialName("all_actual") val allActual: Boolean
)