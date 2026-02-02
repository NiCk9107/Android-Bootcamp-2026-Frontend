
import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.Android

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.header
import io.ktor.http.takeFrom

import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object Network {
    const val HOST = "http://10.0.2.2:8080"

    val client by lazy {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                logger = object  : Logger{
                    override fun log(message: String) {
                        Log.d("KTOR",message)
                    }
                }

            }

            defaultRequest {
                url.takeFrom(HOST)
                header("Accept", "application/json")

            }
        }
    }
}
