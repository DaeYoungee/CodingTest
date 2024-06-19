package com.example.codingtest.level1

class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        var failureRateList = emptyList<Pair<Int, Double>>()
        var totalStageCount = stages.size

        for (i in 1..N) {
            val count = stages.count { it == i }
            failureRateList = if (totalStageCount != 0) {
                failureRateList + (i to count.toDouble()/totalStageCount)
            } else {
                failureRateList + (i to count.toDouble())
            }
            totalStageCount -= count
        }

        return failureRateList.sortedByDescending { it.second }.map { it.first }.toIntArray()
    }
}

fun main() {
    println(FailureRate().solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).contentToString())
    println(FailureRate().solution(5, intArrayOf(2, 1, 2, 2, 4, 3, 3)).contentToString())
}