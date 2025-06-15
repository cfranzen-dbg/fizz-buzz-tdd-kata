package de.cfranzen.kata.fizzbuzz.adapters.outbound

import de.cfranzen.kata.fizzbuzz.domain.ports.outbound.BuzzRepository
import java.nio.file.Path
import kotlin.io.path.readLines

class FileBuzzRepositoryAdapter(private val datasetFile: Path) : BuzzRepository {

    private val values = readValues()

    override fun contains(n: Int): Boolean {
        return values.contains(n)
    }

    private fun readValues(): Set<Int> {
        return datasetFile.readLines().map {
            it.toInt()
        }.toSet()
    }
}