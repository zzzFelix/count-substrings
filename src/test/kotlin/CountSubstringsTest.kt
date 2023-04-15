import kotlin.test.Test
import kotlin.test.assertEquals

internal class CountSubstringsTest {

    private val countSubstrings: CountSubstrings = CountSubstrings()

    @Test
    fun `should create map from string`() {
        val expected = mapOf(
            Pair("this", 2),
            Pair("is", 2),
            Pair("x", 3),
            Pair("a", 1),
            Pair("tes", 1),
            Pair("test", 1),
            Pair("cheese", 1)
        )

        val actual = countSubstrings.printAll("this is a tes test this is x x x cheese")

        assertEquals(expected, actual)
    }

    @Test
    fun `should return empty map when given empty string`() {
        val expected: Map<String, Int> = mapOf()

        val actual = countSubstrings.printAll("")

        assertEquals(expected, actual)
    }

    @Test
    fun `should return empty map when given single space character`() {
        val expected: Map<String, Int> = mapOf()

        val actual = countSubstrings.printAll(" ")

        assertEquals(expected, actual)
    }

    @Test
    fun `should ignore leading and trailing spaces`() {
        val expected: Map<String, Int> = mapOf(Pair("test", 1))

        val actual = countSubstrings.printAll(" test ")

        assertEquals(expected, actual)
    }

    @Test
    fun `should ignore double space`() {
        val expected: Map<String, Int> = mapOf(Pair("test", 2))

        val actual = countSubstrings.printAll("test  test")

        assertEquals(expected, actual)
    }


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

        val actual = countSubstrings.topN(given, 3)

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

        val actual = countSubstrings.topN(given, 99)

        assertEquals(given.size, actual.size)
    }


    @Test
    fun `should not return anything when n=0`() {
        val given = mapOf(
            Pair("this", 2),
            Pair("is", 2)
        )

        val actual = countSubstrings.topN(given, 0)

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

        val actual = countSubstrings.topN(given, 3)

        val expected = mapOf(
            Pair("a", 2),
            Pair("b", 2),
            Pair("is", 2)
        )
        assertEquals(expected, actual)
    }
}