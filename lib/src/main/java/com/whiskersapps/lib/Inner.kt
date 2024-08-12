package com.whiskersapps.lib

fun getInnerMatch(original: String, search: String): Boolean{
    val originalChars = original.toSet()
    return search.all { it in originalChars }
}