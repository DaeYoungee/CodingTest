package com.example.codingtest.level2.queue

import java.util.*

// 프로세스, 우선순위 큐 사용
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
class Process {
    fun solution(priorities: IntArray, location: Int): Int {
        val priorityQueue: Queue<Pair<Int, Int>> = LinkedList()

        var data  = 0
        for (i in priorities.indices) {
            priorityQueue.add(priorities[i] to data++)
        }

        var order = 0
        while (priorityQueue.isNotEmpty()) {
            val max = priorityQueue.maxOf { it.first }
            val (priority, d) = priorityQueue.poll()!!

            // 뽑은 데이터의 우선순위가 queue에 있는 우선순위보다 낮은 경우 다시 queue에 추가
            if (max > priority) {
                priorityQueue.add(priority to d)
                continue
            }
            order++
            if (d == location) {
                return order
            }

        }

        var answer = 0
        return answer
    }
}

fun main() {
    Process().solution(intArrayOf(9, 9, 6), 2)
}