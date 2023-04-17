class CountSubstrings {
    fun createMapFromString(input: String): Map<String, Int> {
        val delimiter = ' '
        val map: HashMap<String, Int> = hashMapOf()

        var currentWord = ""
        for (index in input.indices) {
            val char = input[index]
            val isCharDelimiter = char == delimiter

            if (isCharDelimiter && currentWord.isNotBlank()) {
                val currentValue = map.getOrDefault(currentWord, 0)
                map[currentWord] = currentValue + 1
                currentWord = ""
            } else if (!isCharDelimiter) {
                currentWord += char
            }
        }

        if (currentWord.isNotBlank()) {
            val currentValue = map.getOrDefault(currentWord, 0)
            map[currentWord] = currentValue + 1
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
        if (map.size < 2){
            return map
        }

        val items = map.toList()
        val pivot = items[items.count()/2].second
        val equal = arrayListOf<Pair<String, Int>>()
        val less = arrayListOf<Pair<String, Int>>()
        val greater = arrayListOf<Pair<String, Int>>()

        for (i in items.indices) {
            val item = items[i]
            if (item.second == pivot) {
                equal.add(item)
            } else if (item.second < pivot) {
                less.add(item)
            } else {
                greater.add(item)
            }
        }

        return sortByValueDescending(greater.toMap()) + equal + sortByValueDescending(less.toMap())
    }
}