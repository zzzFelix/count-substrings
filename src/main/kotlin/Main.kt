fun main(args: Array<String>) {
    val text = "this is a tes test this is x x x cheese"

    val map = PrintAll().printAll(text)

    TopN().topN(map, 3)
}