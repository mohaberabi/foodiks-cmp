package com.mohaberabi.kmp.foodiks.core.data.network.factory

import com.mohaberabi.kmp.foodiks.platform.AppLogger
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val engine: HttpClientEngine
) {
    fun create(): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                        prettyPrint = true
                    },
                )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            install(Logging) {
                level = LogLevel.ALL

                logger = object : io.ktor.client.plugins.logging.Logger {
                    override fun log(message: String) {
                        AppLogger.d(
                            "HttpClientFactory",
                            message
                        )
                    }
                }
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
            }

        }
    }
}