package com.whiskersapps.lib

fun getContainMatch(original: String, search: String): Boolean{
    val firstWord = original.replace(" ", "")
    val secondWord = search.replace(" ", "")

    return firstWord.contains(secondWord)
}