package uk.kulikov.api.model.stats

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalDateJsonModel(
    @SerialName("year")
    val year: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("day")
    val day: Int
)

fun LocalDateJsonModel.toLocalDate() = LocalDate(year, month, day)