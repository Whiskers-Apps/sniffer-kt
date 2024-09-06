package com.whiskersapps.lib

/** An object containing the results of all the algorithms*/
data class SnifferResult(
    val levenshtein: Int,
    val hamming: Int,
    val jaroWinkler: Double,
    val inner: Boolean
)