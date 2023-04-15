class PrintAll {
    fun printAll(text: String): Map<String, Int> {
        val map: HashMap<String, Int> = hashMapOf()

        text.split(" ").filter { it.isNotBlank() }.forEach {
            val oldValue = map.getOrDefault(it, 0)
            map[it] = oldValue + 1
        }

        println(map)
        return map
    }
}