class TopN {
    fun topN(map: Map<String, Int>, n: Int): Map<String, Int> {
        val sortedMap = sortByKeyAndValue(map)

        val reducedMap = hashMapOf<String, Int>()
        for (key in sortedMap.keys) {
            if (reducedMap.size == n) break
            reducedMap[key] = sortedMap[key]!!
        }

        println(reducedMap)
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