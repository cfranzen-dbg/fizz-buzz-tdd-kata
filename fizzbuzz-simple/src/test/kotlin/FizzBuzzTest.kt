import de.cfranzen.kata.fizzbuzz.FizzBuzz
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class FizzBuzzTest {

    val sut = FizzBuzz()

    @Test
    fun returnsNumberItself() {
        val inputs = listOf(1, 2, 4, 7, 8, 11)
        for (n in inputs) {
            val result = sut.convert(n)
            assertThat(result).isEqualTo("$n")
        }
    }

    @Test
    fun returnsFizz() {
        val inputs = listOf(3, 6, 9, 12)
        for (n in inputs) {
            val result = sut.convert(n)
            assertThat(result).isEqualTo("Fizz")
        }
    }

    @Test
    fun returnsBuzz() {
        val inputs = listOf(5, 10, 20, 25)
        for (n in inputs) {
            val result = sut.convert(n)
            assertThat(result).isEqualTo("Buzz")
        }
    }

    @Test
    fun returnsFizzBuzz() {
        val inputs = listOf(0, 15, 30, 45)
        for (n in inputs) {
            val result = sut.convert(n)
            assertThat(result).isEqualTo("FizzBuzz")
        }
    }
}