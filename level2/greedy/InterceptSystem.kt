package com.example.codingtest.level2.greedy

// 요격 시스템
class InterceptSystem {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 1

        val list = targets.map { it.toList() }.sortedBy { it[0] }

        targets.sortBy { it[0] }
        println(list)

        var range =  0 to 0
        for (target in targets) {

            // 초기 설정
            if (range == 0 to 0) {
                range = target[0] to target[1]
                continue
            }

            // 공통적인 범위로 축소
            if (target[0] < range.second) {
                range = Math.max(range.first, target[0]) to Math.min(range.second, target[1])
            } else {
                range = target[0] to target[1]
                answer++
            }
            println(range)
        }



        return answer
    }
}

fun main() {
    println(InterceptSystem().solution(arrayOf(intArrayOf(4, 5), intArrayOf(4, 8), intArrayOf(10, 14), intArrayOf(11, 13), intArrayOf(5, 12), intArrayOf(3, 7), intArrayOf(1, 4))))
}