package uk.kulikov.api

import io.ktor.client.request.*
import io.ktor.http.*
import uk.kulikov.api.model.AddressResponse
import uk.kulikov.utils.Constants.BASE_URL

class AddressesApi(
    private val authHelper: AuthHelper
) {

    suspend fun getAddresses(): List<AddressResponse> {
        return authHelper.makeRequestWithAuth<List<AddressResponse>>(HttpMethod.Get) {
            url("$BASE_URL/v1/customer/addresses")
        }
    }
}