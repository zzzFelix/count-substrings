import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TopNTest {
    private val topN: TopN = TopN()

    @Test
    fun `should return top 3 substrings`() {
        val given = mapOf(
            Pair("this", 2),
            Pair("is", 2),
            Pair("x", 3),
            Pair("a", 1),
            Pair("tes", 1),
            Pair("test", 1),
            Pair("cheese", 1)
        )

        val actual = topN.topN(given, 3)

        val expected = mapOf(
            Pair("x", 3),
            Pair("this", 2),
            Pair("is", 2)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `should not return more substrings than given`() {
        val given = mapOf(
            Pair("this", 2),
            Pair("is", 2)
        )

        val actual = topN.topN(given, 99)

        assertEquals(given.size, actual.size)
    }


    @Test
    fun `should not return anything when n=0`() {
        val given = mapOf(
            Pair("this", 2),
            Pair("is", 2)
        )

        val actual = topN.topN(given, 0)

        val expected: Map<String, Int> = mapOf()
        assertEquals(expected, actual)
    }

    @Test
    fun `should order alphabetically when more than n keys have same weight`() {
        val given = mapOf(
            Pair("z", 2),
            Pair("is", 2),
            Pair("a", 2),
            Pair("test", 2),
            Pair("b", 2)
        )

        val actual = topN.topN(given, 3)

        val expected = mapOf(
            Pair("a", 2),
            Pair("b", 2),
            Pair("is", 2)
        )
        assertEquals(expected, actual)
    }
}