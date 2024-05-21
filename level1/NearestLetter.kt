package com.example.codingtest.level1

class NearestLetter {
    fun solution(s: String): IntArray {
        val strMap = hashMapOf<Char, Int>()
        return s.mapIndexed { index, ch ->
            if (!strMap.containsKey(ch)) {
                strMap[ch] = index + 1
                -1
            } else {
                val result = index + 1 - strMap[ch]!!
                strMap[ch] = index + 1
                result
            }

        }.toIntArray()
    }
}

fun main() {
    println(NearestLetter().solution("banana").contentToString())
    println(NearestLetter().solution("foobar").contentToString())

}