package uk.kulikov.api.model.readings.days

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HalfHourReading(
    @SerialName("status")
    val status: String,
    @SerialName("tpr_customer_name")
    val tprCustomerName: String? = null,
    @SerialName("reading_kWh")
    val readingKWh: String? = null,
    @SerialName("start_time_local")
    @Serializable(with = LocalDateTimeSerializer::class)
    val startTimeLocal: LocalDateTime? = null,
    @SerialName("end_time_local")
    @Serializable(with = LocalDateTimeSerializer::class)
    val endTimeLocal: LocalDateTime? = null,
)