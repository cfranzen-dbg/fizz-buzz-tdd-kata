package de.cfranzen.kata.fizzbuzz.domain

import de.cfranzen.kata.fizzbuzz.domain.ports.inbound.ConvertNumberToStringUsecase
import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.BuzzRepository
import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.FizzDetector

class FizzBuzzService(
    val fizzDetector: FizzDetector,
    val buzzRepository: BuzzRepository
) : ConvertNumberToStringUsecase {

    override fun convert(n: Int): String {
        val isFizz = fizzDetector.isFizz(n)
        val isBuzz = buzzRepository.contains(n)

        if (isFizz && isBuzz) {
            return "FizzBuzz"
        } else if (isFizz) {
            return "Fizz"
        } else if (isBuzz) {
            return "Buzz"
        }
        return n.toString()
    }
}