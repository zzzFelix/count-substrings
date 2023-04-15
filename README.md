# Count substrings

[![Test Results](https://gist.githubusercontent.com/zzzFelix/235fbefc8e6f330d8b86cc2d2ee7dbe0/raw/101e4fbc1740928e310b41f632cd10af739d5ea1/badge.svg)](https://gist.githubusercontent.com/zzzFelix/235fbefc8e6f330d8b86cc2d2ee7dbe0/raw/101e4fbc1740928e310b41f632cd10af739d5ea1/badge.svg)

This repository contains two methods:

### `createMapFromString(text: String): Map<String, Int>`

- Input: String that contains 0 to _n_ whitespace-separated substrings, e.g. `penguin giraffe lion penguin penguin`
- Output: Map with all given substrings as keys and the number of occurrences as value, e.g. `penguin=3, giraffe=1, lion=1`

### `topN(map: Map<String, Int>, n: Int): Map<String, Int>`
- Input: Map with substrings and the number of their occurrences; value _n_ to determine the desired key-value pairs in the output.
- Output: The _n_ key-value pairs with the highest values from the input map. When multiple key-value pairs have the same value, they are sorted alphabetically.

### Time Complexity and Space Complexity
- O(n*logn + m) time, O(n) space, where n is the number of substrings (words), m the length of the input string.

### Run
`./gradlew run --args='penguin giraffe lion cat penguin penguin lion dog cat dog`