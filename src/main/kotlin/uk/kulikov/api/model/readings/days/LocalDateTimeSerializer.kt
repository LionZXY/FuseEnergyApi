package uk.kulikov.api.model.readings.days

import kotlinx.datetime.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return Instant.parse(decoder.decodeString()).toLocalDateTime(TimeZone.currentSystemDefault())
    }

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        val dateTime = value.toInstant(TimeZone.currentSystemDefault()).toString()
        encoder.encodeString(dateTime)
    }
}