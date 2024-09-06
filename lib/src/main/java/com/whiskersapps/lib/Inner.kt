package com.whiskersapps.lib

/**
 * Returns true if all the search characters are inside of the original string.
 */
fun getInnerMatch(original: String, search: String): Boolean{
    val originalChars = original.toSet()
    return search.all { it in originalChars }
}