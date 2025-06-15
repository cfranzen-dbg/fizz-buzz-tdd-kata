package de.cfranzen.kata.fizzbuzz

import de.cfranzen.kata.fizzbuzz.adapters.inbound.CliAdapter
import de.cfranzen.kata.fizzbuzz.adapters.outbound.FileBuzzRepositoryAdapter
import de.cfranzen.kata.fizzbuzz.adapters.outbound.FizzServiceAdapter
import de.cfranzen.kata.fizzbuzz.domain.FizzBuzzService
import java.io.OutputStream
import java.nio.file.Path

fun main(args: Array<String>) {
    val cliAdapter = configure(
        buzzDatasetFile = Path.of("fizzbuzz-hexa/src/main/resources/buzz_dataset.txt"),
        httpBaseUrl = "http://localhost:8080",
        outStream = System.out
    )
    cliAdapter.invoke(args)
}

fun configure(
    buzzDatasetFile: Path,
    httpBaseUrl: String,
    outStream: OutputStream
): CliAdapter {
    val buzzRepoAdapter = FileBuzzRepositoryAdapter(buzzDatasetFile)
    val fizzServiceAdapter = FizzServiceAdapter(httpBaseUrl)
    val usecase = FizzBuzzService(fizzServiceAdapter, buzzRepoAdapter)
    return CliAdapter(outStream, usecase)
}