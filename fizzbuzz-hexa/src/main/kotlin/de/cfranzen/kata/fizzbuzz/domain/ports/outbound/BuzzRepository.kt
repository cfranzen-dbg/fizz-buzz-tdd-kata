package de.cfranzen.kata.fizzbuzz.domain.ports.outbound

interface BuzzRepository {

    fun contains(n: Int): Boolean
}