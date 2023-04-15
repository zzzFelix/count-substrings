class CountSubstrings {
    fun createMapFromString(text: String): Map<String, Int> {
        val map: HashMap<String, Int> = hashMapOf()

        text.split(" ").filter { it.isNotBlank() }.forEach {
            val oldValue = map.getOrDefault(it, 0)
            map[it] = oldValue + 1
        }

        return map
    }

    fun topN(map: Map<String, Int>, n: Int): Map<String, Int> {
        val sortedMap = sortByKeyAndValue(map)

        val reducedMap = hashMapOf<String, Int>()
        for (key in sortedMap.keys) {
            if (reducedMap.size == n) break
            reducedMap[key] = sortedMap[key]!!
        }

        return reducedMap
    }

    private fun sortByKeyAndValue(map: Map<String, Int>): Map<String, Int> {
        val sortedByKey = sortByKeyAscending(map)
        return sortByValueDescending(sortedByKey)
    }

    private fun sortByKeyAscending(map: Map<String, Int>): Map<String, Int> {
        return map.toList().sortedBy { it.first }.toMap()
    }

    private fun sortByValueDescending(map: Map<String, Int>): Map<String, Int> {
        return map.toList().sortedByDescending { it.second }.toMap()
    }
}