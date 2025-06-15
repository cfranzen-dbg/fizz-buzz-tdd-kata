package de.cfranzen.kata.fizzbuzz.adapters.inbound

import de.cfranzen.kata.fizzbuzz.domain.ports.inbound.ConvertNumberToStringUsecase
import java.io.OutputStream

class CliAdapter(
    private val outStream: OutputStream,
    private val usecase: ConvertNumberToStringUsecase
) {

    fun invoke(args: Array<String>) {
        val n = Integer.parseInt(args[0])
        val result = usecase.convert(n)
        outStream.write(result.encodeToByteArray())
    }
}