package com.whiskersapps.lib



/** Returns the similarity of both strings. From 0 to 1 */
fun getJaroWinklerDistance(original: String, search: String): Double {
    val originalSize = original.length
    val searchSize = search.length

    if (originalSize == 0 && searchSize == 0) return 1.0

    val matchDistance = (maxOf(originalSize, searchSize) / 2) - 1

    val originalMatches = BooleanArray(originalSize)
    val searchMatches = BooleanArray(searchSize)

    var matches = 0
    var transpositions = 0

    for (i in 0..<originalSize) {
        val start = maxOf(0, i - matchDistance)
        val end = minOf(i + matchDistance + 1, searchSize)

        for (j in start..<end) {
            if (!searchMatches[j] && original[i] == search[j]) {
                originalMatches[i] = true
                searchMatches[j] = true
                matches++
                break
            }
        }
    }

    if (matches == 0) return 0.0

    var transpositionsCount = 0
    for (i in 0..<originalSize) {
        if (originalMatches[i]) {
            while (!searchMatches[transpositionsCount]) {
                transpositionsCount++
            }

            if (original[i] != search[transpositionsCount]) {
                transpositions++
            }

            transpositionsCount++
        }
    }

    transpositions /= 2

    val jaro = ((matches / originalSize.toDouble()) +
            (matches / searchSize.toDouble()) +
            ((matches - transpositions) / matches.toDouble())) / 3.0

    val prefixLength = original.zip(search).takeWhile { it.first == it.second }.count().coerceAtMost(4)

    val jaroWinkler = jaro + (0.1 * prefixLength * (1 - jaro))

    return jaroWinkler
}