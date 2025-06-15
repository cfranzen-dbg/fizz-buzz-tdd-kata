package de.cfranzen.kata.fizzbuzz

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir
import java.io.ByteArrayOutputStream
import java.nio.file.Path
import kotlin.io.path.writeLines
import kotlin.test.Test

@WireMockTest
class AcceptanceTest {

    @Test
    fun appReturnFizzBuzz(wmRuntimeInfo: WireMockRuntimeInfo, @TempDir tempFolder: Path) {
        // Given
        stubFor(get("/fizz/1").willReturn(ok()))
        val tempFile = tempFolder.resolve("buzz_dataset.txt")
        tempFile.writeLines(listOf("1", "2", "3"))
        val args = arrayOf("1")
        val outStream = ByteArrayOutputStream()

        // When
        val cliAdapter = configure(tempFile, wmRuntimeInfo.httpBaseUrl, outStream)
        cliAdapter.invoke(args)

        // Then
        assertThat(outStream.toString()).isEqualTo("FizzBuzz")
    }
}