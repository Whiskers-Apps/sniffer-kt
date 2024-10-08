package com.whiskersapps.lib

/**
 * Returns the amount of different positional characters.
 */
fun getHammingDistance(original: String, search: String): Int{

    if(original.length != search.length){
        throw(IllegalArgumentException("String must be the same length"))
    }

    var distance = 0

    for (i in original.indices) {
        if (original[i] != search[i]) {
            distance++
        }
    }

    return distance
}