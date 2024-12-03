package uk.kulikov.api.model.readings.pagination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MonthPagination(
    @SerialName("previous_index")
    val previousIndex: MonthPage,
    @SerialName("current_index")
    val currentIndex: MonthPage,
    @SerialName("next_index")
    val nextIndex: MonthPage,
)