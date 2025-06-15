package de.cfranzen.kata.fizzbuzz.adapters.outbound

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import kotlin.io.path.writeLines
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FileBuzzRepositoryAdapterTest {

    @TempDir
    lateinit var tempFolder: Path

    @Test
    fun numberIsContainedByRepo() {
        val sut = createRepo(listOf("1", "2", "3"))
        assertTrue { sut.contains(1) }
    }

    @Test
    fun numberIsNotContainedByRepo() {
        val sut = createRepo(listOf("1", "2", "3"))
        assertFalse { sut.contains(4) }
    }

    @Test
    fun emptyRepoDoesNotContainAnything() {
        val sut = createRepo(emptyList())
        assertFalse { sut.contains(1) }
    }

    @Test
    fun throwOnUnparsableDataset() {
        assertThrows<IllegalArgumentException> {
            createRepo(listOf("1", "unparsable", "3"))
        }
    }

    private fun createRepo(datasetValues: List<String>): FileBuzzRepositoryAdapter {
        val tempFile = tempFolder.resolve("buzz_dataset.txt")
        tempFile.writeLines(datasetValues)
        return FileBuzzRepositoryAdapter(tempFile)
    }
}