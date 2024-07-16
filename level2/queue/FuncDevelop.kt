package com.example.codingtest.level2.queue

import java.util.*

// 기능 개발, 큐 사용
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
class FuncDevelop {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        val speedQueue: Queue<Int> = LinkedList()
        // 우선순위의 크기가 작을 수록 우선순위가 높음
        for ((i,pro) in progresses.withIndex()) {
            queue.add(pro)
            speedQueue.add(speeds[i])
        }

        var day = 0
        var count = 0
        val result = mutableListOf<Int>()

        println(queue)

        while (queue.isNotEmpty()) {

            if (queue.element()!! + speedQueue.element()!! * day >= 100) {
                count++
                queue.remove()
                speedQueue.remove()
            } else {
                if (count >= 1) {
                    result.add(count)
                    count = 0
                }
                day++
            }
        }
        result.add(count)

        return result.toIntArray()
    }
}

fun main() {
    FuncDevelop().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    FuncDevelop().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
}