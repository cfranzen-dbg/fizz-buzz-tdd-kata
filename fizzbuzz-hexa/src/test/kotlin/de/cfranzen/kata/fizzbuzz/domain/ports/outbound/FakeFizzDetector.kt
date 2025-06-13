package de.cfranzen.kata.fizzbuzz.domain.ports.outbound

class FakeFizzDetector : FizzDetector {

    var fizz: Boolean = false

    override fun isFizz(n: Int): Boolean {
        return fizz
    }

}