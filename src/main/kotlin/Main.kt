fun main(args: Array<String>) {
    val countSubstrings = CountSubstrings()

    // Given a text
    // 1 - Print the number occurences of each string in a map
    // 2 - Print the top N most popular words in order (most popular first)

    val text = "this is a tes test this is x x x cheese"

    // 1
    val map = countSubstrings.createMapFromString(text)
    println(map)

    // 2
    val topN = countSubstrings.topN(map, 3)
    println(topN)
}