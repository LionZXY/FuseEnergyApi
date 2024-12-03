package uk.kulikov.api.model.readings.days

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayReadings(
    @SerialName("date_uk")
    @Serializable(with = LocalDateSerializer::class)
    val dateUK: LocalDate,
    @SerialName("readings")
    val readings: List<HalfHourReading>
)