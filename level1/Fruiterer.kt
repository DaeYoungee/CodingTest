package com.example.codingtest.level1

class Fruiterer {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var totalScore = 0
        score.sortedDescending().forEachIndexed { index, i ->
            if ((index+1) % m == 0) {
                totalScore += i*m
            }
        }
        return totalScore
    }
}

fun main() {
    println(Fruiterer().solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
    println(Fruiterer().solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))


}