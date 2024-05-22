package com.example.codingtest.level1

class HallOfFame {
    fun solution(k: Int, score: IntArray): IntArray {
        val honorList = IntArray(k) { -1 }
        var fallScore = 0
        return score.mapIndexed { index, score ->
            if (honorList[k - 1] == -1) {
                honorList[index] = score
                honorList.sortDescending()
                honorList[index]
            } else {
                if (honorList[k - 1] < score) {
                    honorList[k - 1] = score
                }
                honorList.sortDescending()
                honorList[k - 1]
            }
        }.toIntArray()
    }

    fun solution1(k: Int, score: IntArray): IntArray = score.mapIndexed { index, sc ->
        score.copyOfRange(0, index + 1).sortedDescending().run { getOrNull(k - 1) ?: minOf { it } }
    }.toIntArray()
}


fun main() {
    println(HallOfFame().solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).contentToString())
}