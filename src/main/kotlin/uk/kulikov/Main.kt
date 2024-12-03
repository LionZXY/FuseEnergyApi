package uk.kulikov

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import uk.kulikov.api.AddressesApi
import uk.kulikov.api.AuthHelper
import uk.kulikov.api.ReadingStatsApi
import uk.kulikov.api.model.readings.pagination.MonthPage

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                explicitNulls = false
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }
    }

    val auth = AuthHelper(client)
    val addressesApi = AddressesApi(auth)
    val statsApi = ReadingStatsApi(auth)

    val addresses = addressesApi.getAddresses()
    println(addresses)

    val date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val stats = statsApi.fetchAllReadingsForMonth(addresses.first(), MonthPage(date.year, date.monthNumber))
    println(stats)
}