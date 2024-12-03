package uk.kulikov.config

import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.io.decodeFromSource
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.io.encodeToSink

private const val CONFIG_PATH = "data/config.json"

@Serializable
data class FuseApiConfig(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String
) {
    companion object {
        var instance = SystemFileSystem.source(Path(CONFIG_PATH)).use {
            Json.decodeFromSource<FuseApiConfig>(it.buffered())
        }
            private set

        suspend fun updateConfig(block: suspend (FuseApiConfig) -> FuseApiConfig) {
            instance = block(instance)
            SystemFileSystem.sink(Path(CONFIG_PATH)).buffered().use {
                Json.encodeToSink(instance, it)
            }
        }
    }
}