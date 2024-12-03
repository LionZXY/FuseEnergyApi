package uk.kulikov.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.reflect.*
import uk.kulikov.api.model.RefreshTokenRequest
import uk.kulikov.api.model.RefreshTokenResponse
import uk.kulikov.config.FuseApiConfig
import uk.kulikov.utils.Constants.BASE_URL

class AuthHelper(
    private val client: HttpClient
) {

    private suspend fun refreshToken() {
        val config = FuseApiConfig.instance
        val response = client.post("$BASE_URL/v1/auth/refresh") {
            setBody(
                RefreshTokenRequest(
                    refreshToken = config.refreshToken
                )
            )
            contentType(ContentType.Application.Json)
            bearerAuth(config.accessToken)
        }.body<RefreshTokenResponse>()

        FuseApiConfig.updateConfig {
            FuseApiConfig(
                accessToken = response.accessToken,
                refreshToken = response.refreshToken
            )
        }
    }

    suspend fun <T> makeRequestWithAuth(
        typeInfo: TypeInfo,
        method: HttpMethod = HttpMethod.Post,
        block: HttpRequestBuilder.() -> Unit
    ): T {
        var httpResponse = makeRequest(FuseApiConfig.instance.accessToken, method, block)

        if (httpResponse.status == HttpStatusCode.Unauthorized) {
            refreshToken()
            httpResponse = makeRequest(FuseApiConfig.instance.accessToken, method, block)
        }
        return httpResponse.call.bodyNullable(typeInfo) as T
    }

    private suspend fun makeRequest(
        accessToken: String,
        method: HttpMethod,
        block: HttpRequestBuilder.() -> Unit
    ): HttpResponse {
        val builder = HttpRequestBuilder()
        builder.contentType(ContentType.Application.Json)
        builder.method = method // Default

        builder.block()

        builder.bearerAuth(accessToken)

        return client.request(builder)
    }
}

suspend inline fun <reified T> AuthHelper.makeRequestWithAuth(
    method: HttpMethod = HttpMethod.Post,
    noinline block: HttpRequestBuilder.() -> Unit
): T = makeRequestWithAuth(typeInfo<T>(), method, block)