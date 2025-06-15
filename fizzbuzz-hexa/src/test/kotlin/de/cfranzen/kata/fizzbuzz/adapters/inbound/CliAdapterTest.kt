package de.cfranzen.kata.fizzbuzz.adapters.inbound

import de.cfranzen.kata.fizzbuzz.domain.ports.inbound.ConvertNumberToStringUsecase
import io.mockk.called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import kotlin.test.Test

class CliAdapterTest {

    val outStream = ByteArrayOutputStream()

    val usecase = mockk<ConvertNumberToStringUsecase>(relaxed = true)

    val sut = CliAdapter(outStream, usecase)

    @Test
    fun parseNumberAndWriteToStdout() {
        val expectedResult = "This is a string that cannot be produced by the domain logic"
        val args = arrayOf("1")
        every { usecase.convert(any()) } returns expectedResult

        sut.invoke(args)

        assertThat(outStream.toString()).isEqualTo(expectedResult)
        verify { usecase.convert(1) }
    }

    @Test
    fun throwOnUnparsableNumber() {
        val expectedResult = "This is a string that cannot be produced by the domain logic"
        val args = arrayOf("unparsable")
        every { usecase.convert(any()) } returns expectedResult

        assertThrows<IllegalArgumentException> { sut.invoke(args) }

        assertThat(outStream.toString()).isEmpty()
        verify { usecase wasNot called }
    }
}