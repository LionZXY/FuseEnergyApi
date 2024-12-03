package uk.kulikov.api.model.readings.pagination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonthPage(
    @SerialName("year")
    val year: Int,
    @SerialName("month")
    val month: Int
)