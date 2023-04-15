import kotlin.test.Test
import kotlin.test.assertEquals

internal class PrintAllTest {

    private val printAll: PrintAll = PrintAll()

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
        assertEquals(expected, printAll.printAll("this is a tes test this is x x x cheese"))
    }

    @Test
    fun `should return empty map when given empty string`() {
        val expected: Map<String, Int> = mapOf()
        assertEquals(expected, printAll.printAll(""))
    }

    @Test
    fun `should return empty map when given single space character`() {
        val expected: Map<String, Int> = mapOf()
        assertEquals(expected, printAll.printAll(" "))
    }

    @Test
    fun `should ignore leading and trailing spaces`() {
        val expected: Map<String, Int> = mapOf(Pair("test", 1))
        assertEquals(expected, printAll.printAll(" test "))
    }

    @Test
    fun `should ignore double space`() {
        val expected: Map<String, Int> = mapOf(Pair("test", 2))
        assertEquals(expected, printAll.printAll("test  test"))
    }
}