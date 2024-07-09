package com.example.codingtest.level2

// 시소 짝꿍
class Seesaw {
    fun solution(weights: IntArray): Long {
        var count = 0L

        weights.sort()

        for (i in weights.indices) {
            for (j in i + 1 until weights.size) {
                if (weights[i] == weights[j]) count++
                else if (weights[i]*2 == weights[j]) count++
                else if (weights[i]*3 == weights[j]*2) count++
                else if (weights[i]*4 == weights[j]*3) count++
            }
        }

        return count
    }
}

fun main() {
    println(Seesaw().solution(intArrayOf(100,180,360,100,270)))
}