package com.getbux.simplebux.kmm.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.headersOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Money(
    val currency: String,
    val decimals: Int,
    var amount: Double
)

@Serializable
data class Product(
    val symbol: String,
    val displayName: String,
    val securityId: String,
    val currentPrice: Money,
    val closingPrice: Money,
)

class BuxAPI {

    private val baseUrl = "https://api.beta.getbux.com/core/21"

    private val nonStrictJson = Json { isLenient = true; ignoreUnknownKeys = true  }

    private val client by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(nonStrictJson)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            defaultRequest {
                header("Accept-Language", "nl-NL,en;q=0.8")
                header("Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJyZWZyZXNoYWJsZSI6ZmFsc2UsInN1YiI6ImJiMGNkYTJiLWE" +
                        "xMGUtNGVkMy1hZDVhLTBmODJiNGMxNTJjNCIsImF1ZCI6ImJldGEuZ2V0YnV4LmNvbSIsInN" +
                        "jcCI6WyJhcHA6bG9naW4iLCJydGY6bG9naW4iXSwiZXhwIjoxODIwODQ5Mjc5LCJpYXQiOjE" +
                        "1MDU0ODkyNzksImp0aSI6ImI3MzlmYjgwLTM1NzUtNGIwMS04NzUxLTMzZDFhNGRjOGY5MiI" +
                        "sImNpZCI6Ijg0NzM2MjI5MzkifQ.M5oANIi2nBtSfIfhyUMqJnex-JYg6Sm92KPYaUL9GKg")
            }
        }
    }

    suspend fun fetchProducts() = client.get<Product>("$baseUrl/products/sb26493")
}