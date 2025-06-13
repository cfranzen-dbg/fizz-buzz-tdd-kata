package de.cfranzen.kata.fizzbuzz.domain.ports.outbound

class FakeBuzzRepository : BuzzRepository {

    val values = mutableSetOf<Int>()

    override fun contains(n: Int): Boolean {
        return values.contains(n)
    }
}