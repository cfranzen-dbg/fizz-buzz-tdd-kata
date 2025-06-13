package de.cfranzen.kata.fizzbuzz.domain.ports.outbound

interface FizzDetector {

    fun isFizz(n: Int): Boolean
}