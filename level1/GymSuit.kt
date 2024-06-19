package com.example.codingtest.level1

// 체육복
class GymSuit {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n
        var lostSet = lost.toSet() - reserve.toSet()
        var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

        for (i in lostSet) {
            when {
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                else -> answer--
            }
        }
        return answer
    }
}

// Set - Set 연산은 공통된 원소를 제거한다!

fun main() {
    println(GymSuit().solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(GymSuit().solution(5, intArrayOf(2, 4), intArrayOf(2, 3)))
    println(GymSuit().solution(5, intArrayOf(2, 4), intArrayOf(3)))
    println(GymSuit().solution(3, intArrayOf(3), intArrayOf(1)))
    println(GymSuit().solution(5, intArrayOf(4, 2), intArrayOf(5, 3)))
}