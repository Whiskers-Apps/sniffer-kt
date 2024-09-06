package com.whiskersapps.lib

data class Sniffer(
    /** The amount of characters that can be different*/
    private val levenshteinDistance: Int = 2,
    /** Use levenshtein match*/
    private val doLevenshteinMatch: Boolean = true,
    /** The amount of positional characters that can be different*/
    private val hammingDistance: Int = 2,
    /** Use hamming match*/
    private val doHammingMatch: Boolean = true,
    /** The difference between the search and the original. From 0.0 to 1.0*/
    private val jaroWinklerDistance: Double = 0.8,
    /** Use jaro winkler match*/
    private val doJaroWinklerMatch: Boolean = true,
    /** Use inner match*/
    private val doInnerMatch: Boolean = true,
    /** Do case-sensitive search*/
    private val caseSensitive: Boolean = false,
) {
    /** Returns true if any of the algorithms has a match between the strings */
    fun matches(original: String, search: String): Boolean {

        val firstWord = if (caseSensitive) original else original.lowercase()
        val secondWord = if (caseSensitive) search.lowercase() else search.lowercase()

        val levenshteinMatch = if (doLevenshteinMatch)
            getLevenshteinDistance(firstWord, secondWord) <= levenshteinDistance
        else
            false

        val hammingMatch = if (doHammingMatch && firstWord.length == secondWord.length)
            getHammingDistance(firstWord, secondWord) <= hammingDistance
        else
            false

        val jaroWinklerMatch = if (doJaroWinklerMatch)
            getJaroWinklerDistance(firstWord, secondWord) >= jaroWinklerDistance
        else
            false

        val innerMatch = if (doInnerMatch)
            getInnerMatch(firstWord, secondWord)
        else
            false

        return levenshteinMatch || hammingMatch || jaroWinklerMatch || innerMatch
    }

    /**
     * Get a sniffer result object containing the results of all the matches.
     * Hamming returns -1 if the strings are a different size*/
    fun getSnifferResult(original: String, search: String): SnifferResult {

        val firstWord = if (caseSensitive) original else original.lowercase()
        val secondWord = if (caseSensitive) search.lowercase() else search.lowercase()

        return SnifferResult(
            levenshtein = getLevenshteinDistance(firstWord, secondWord),
            hamming = if (original.length == search.length)
                getHammingDistance(firstWord, secondWord)
            else
                -1,
            jaroWinkler = getJaroWinklerDistance(firstWord, secondWord),
            inner = getInnerMatch(firstWord, secondWord)
        )
    }
}
