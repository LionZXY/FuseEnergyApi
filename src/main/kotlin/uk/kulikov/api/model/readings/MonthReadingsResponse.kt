package uk.kulikov.api.model.readings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import uk.kulikov.api.model.readings.pagination.MonthPagination
import uk.kulikov.api.model.stats.ReadingsCount

@Serializable
data class MonthReadingsResponse(
    @SerialName("pagination")
    val pagination: MonthPagination,
    @SerialName("counts")
    val counts: ReadingsCount,
    @SerialName("hh_readings")
    val hhReadings: HHReadings
)