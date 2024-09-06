package com.whiskersapps.lib

/**
 * Returns the amount of characters needed to change for the strings to match.
 */
fun getLevenshteinDistance(original: String, search: String): Int {

    val originalSize = original.length
    val searchSize = search.length
    val distance = Array(originalSize + 1){IntArray(searchSize + 1)}

    for(i in 0..originalSize){
        distance[i][0] = i
    }

    for(i in 0..searchSize){
        distance[0][i] = i
    }

    for(i in 1..originalSize){
        for(j in 1..searchSize){
            val cost = if(original[i - 1] == search[j - 1]) 0 else 1

            distance[i][j] = minOf(
                distance[i - 1][j] + 1,
                distance[i][j - 1] + 1,
                distance[i - 1][j - 1] + cost
            )
        }
    }

    return distance[originalSize][searchSize]
}

