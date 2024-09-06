package com.whiskersapps.lib

import junit.framework.Assert.assertEquals
import org.junit.Test

class Testing {
    @Test
    fun levenshtein(){
        val expected = 3
        val actual = getLevenshteinDistance("Banana", "banini")
        assertEquals(expected, actual)
        println("Levenshtein Test Passed")
    }

    @Test
    fun hamming() {
        val expected = 2
        val actual = getHammingDistance("bulbasaur", "bulbysaul")
        assertEquals(expected, actual)
        println("Hamming Test Passed")
    }

    @Test
    fun jaroWinkler() {
        val expected = 0.9666666666666667
        val actual = getJaroWinklerDistance("banana", "banan")
        assertEquals(expected, actual)
        println("Jaro Winker Test Passed")
    }

    @Test
    fun inner() {
        val expected = true
        val actual = getInnerMatch("Sprigatito", "agt")
        assertEquals(expected, actual)
        println("Inner Match Test Passed")
    }

    @Test
    fun sniffer(){
        val sniffer = Sniffer()
        val expected = true
        val actual = sniffer.matches("Banana", "banana")
        assertEquals(expected, actual)
        println("Sniffer Test Passed")
    }

    @Test
    fun snifferResult(){
        val sniffer = Sniffer()
        val result = sniffer.getSnifferResult("Luxray", "lux")

        assertEquals(result.levenshtein, 3)
        assertEquals(result.jaroWinkler, 0.8833333333333334)
        assertEquals(result.inner, true)
    }
}