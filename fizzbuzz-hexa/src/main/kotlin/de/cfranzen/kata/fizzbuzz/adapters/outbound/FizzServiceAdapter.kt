package de.cfranzen.kata.fizzbuzz.adapters.outbound

import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.FizzDetector
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class FizzServiceAdapter(val baseUrl: String) : FizzDetector {

    private val client = HttpClient.newBuilder().build()

    override fun isFizz(n: Int): Boolean {
        val request = HttpRequest.newBuilder().GET().uri(URI.create(baseUrl).resolve("fizz/$n")).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.statusCode() == 200
    }
}