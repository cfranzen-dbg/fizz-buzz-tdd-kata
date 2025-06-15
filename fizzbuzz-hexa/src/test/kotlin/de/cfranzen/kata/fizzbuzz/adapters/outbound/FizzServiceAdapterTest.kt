package de.cfranzen.kata.fizzbuzz.adapters.outbound

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.junit.jupiter.api.assertThrows
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@WireMockTest
class FizzServiceAdapterTest {

    @Test
    fun externalServiceReturnsFizz(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(get("/fizz/1").willReturn(ok()))

        val sut = FizzServiceAdapter(wmRuntimeInfo.httpBaseUrl)

        assertTrue { sut.isFizz(1) }
    }

    @Test
    fun externalServiceReturnsNoFizz(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(get("/fizz/1").willReturn(notFound()))

        val sut = FizzServiceAdapter(wmRuntimeInfo.httpBaseUrl)

        assertFalse { sut.isFizz(1) }
    }

    @Test
    fun throwOnIOError(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(get("/fizz/1").willReturn(ok()))

        val sut = FizzServiceAdapter("http://unkown.host:8080")

        assertThrows<IOException> { sut.isFizz(1) }
    }
}