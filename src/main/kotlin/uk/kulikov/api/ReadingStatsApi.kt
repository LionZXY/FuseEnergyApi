package uk.kulikov.api

import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import uk.kulikov.api.model.AddressResponse
import uk.kulikov.api.model.readings.MonthReadingsResponse
import uk.kulikov.api.model.readings.pagination.MonthPage
import uk.kulikov.api.model.stats.DayStatsResponse
import uk.kulikov.utils.Constants

class ReadingStatsApi(
    private val authHelper: AuthHelper
) {
    suspend fun fetchDataForDay(
        address: AddressResponse,
        date: LocalDate
    ): DayStatsResponse {
        return authHelper.makeRequestWithAuth<DayStatsResponse>(HttpMethod.Get) {
            url("${Constants.BASE_URL}/v4/properties/${address.id}/billing?year=${date.year}&month=${date.monthNumber}&day=${date.dayOfMonth}")
        }
    }

    suspend fun fetchAllReadingsForMonth(
        address: AddressResponse,
        page: MonthPage
    ): MonthReadingsResponse {
        return authHelper.makeRequestWithAuth<MonthReadingsResponse>(HttpMethod.Get) {
            url("${Constants.BASE_URL}/v2/properties/${address.id}/billing-readings?year=${page.year}&month=${page.month}")
        }
   }

}