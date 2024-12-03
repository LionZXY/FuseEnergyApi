package uk.kulikov.api.model.readings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.kulikov.api.model.readings.days.DayReadings

@Serializable
data class HHReadings(
    @SerialName("days")
    val days: List<DayReadings>,
)