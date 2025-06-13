package de.cfranzen.kata.fizzbuzz.domain.ports.inbound

interface ConvertNumberToStringUsecase {

    fun convert(n: Int): String
}