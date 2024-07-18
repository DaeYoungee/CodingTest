package com.example.codingtest.level2.greedy

// 귤 고르기
// https://school.programmers.co.kr/learn/courses/30/lessons/138476
class Mandarin {
    fun solution(k: Int, tangerine: IntArray): Int {
        var count = 0
        var type = 0
        val list = tangerine.toList().groupingBy { it }.eachCount().toList().sortedByDescending { it.second }.toMutableList()
        while (count < k) {
            val orange = list[0]
            if (k-count < orange.second) {
                list[0] = orange.copy(second = orange.second - (k-count))
                count = k
                type++
            } else if (k-count >= orange.second) {
                count += orange.second
                type++
            }
            list.removeFirst()
        }
        return type
    }
}

fun main() {
    Mandarin().solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
}