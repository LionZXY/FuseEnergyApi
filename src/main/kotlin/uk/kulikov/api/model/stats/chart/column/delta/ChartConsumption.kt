package uk.kulikov.api.model.stats.chart.column.delta

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChartConsumption(
    @SerialName("usage") val usage: ChartUsage?,
    @SerialName("usage_and_forecast") val forecast: ChartUsage?,

    )