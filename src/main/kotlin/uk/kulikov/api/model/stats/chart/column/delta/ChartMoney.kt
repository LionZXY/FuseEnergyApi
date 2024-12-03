package uk.kulikov.api.model.stats.chart.column.delta

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChartMoney(
    @SerialName("amount") val amount: String,
    @SerialName("currency") val currency: String,
)