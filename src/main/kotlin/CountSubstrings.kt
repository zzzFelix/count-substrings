class CountSubstrings {
    fun createMapFromString(input: String): Map<String, Int> {
        val delimiter = ' '
        val map: HashMap<String, Int> = hashMapOf()

        input.split(delimiter).filter { it.isNotBlank() }.forEach {
            val oldValue = map.getOrDefault(it, 0)
            map[it] = oldValue + 1
        }

        return map
    }

    fun topN(map: Map<String, Int>, n: Int): Map<String, Int> {
        val sortedMap = sortByKeyAndValue(map)

        val reducedMap = mutableMapOf<String, Int>()

        for (key in sortedMap.keys) {
            if (reducedMap.size == n) break
            reducedMap[key] = sortedMap.getOrDefault(key, 0)
        }

        return reducedMap
    }

    private fun sortByKeyAndValue(map: Map<String, Int>): Map<String, Int> {
        val sortedByKey = sortByKeyAscending(map)
        return sortByValueDescending(sortedByKey)
    }

    private fun sortByKeyAscending(map: Map<String, Int>): Map<String, Int> {
        return map.toSortedMap()
    }

    private fun sortByValueDescending(map: Map<String, Int>): Map<String, Int> {
        return map.toList().sortedByDescending { it.second }.toMap()
    }
}