package de.cfranzen.kata.fizzbuzz.domain

import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.FakeBuzzRepository
import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.FakeFizzDetector
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FizzBuzzServiceTest {

    val buzzRepository = FakeBuzzRepository()

    val fizzDetector = FakeFizzDetector()

    val sut = FizzBuzzService(fizzDetector, buzzRepository)

    @ParameterizedTest(name = "Number {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun returnsNumberItself(n: Int) {
        val result: String = sut.convert(n)
        assertThat(result).isEqualTo("$n")
    }

    @ParameterizedTest(name = "Number {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun returnsFizz(n: Int) {
        fizzDetector.fizz = true

        val result: String = sut.convert(n)
        assertThat(result).isEqualTo("Fizz")
    }

    @ParameterizedTest(name = "Number {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun returnsBuzz(n: Int) {
        buzzRepository.values.add(n)

        val result: String = sut.convert(n)
        assertThat(result).isEqualTo("Buzz")
    }

    @ParameterizedTest(name = "Number {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun returnsFizzBuzz(n: Int) {
        fizzDetector.fizz = true
        buzzRepository.values.add(n)

        val result: String = sut.convert(n)
        assertThat(result).isEqualTo("FizzBuzz")
    }
}