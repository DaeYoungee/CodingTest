package com.example.codingtest.level1

class SmallSubString {
    fun solution(t: String, p: String): Int {
        var count: Int = 0
        for (i in 0..(t.length - p.length)) {
            if (t.substring(i, p.length + i) <= p) count++
        }
        return count
    }
}

fun main () {

}