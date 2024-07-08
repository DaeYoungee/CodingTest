package com.example.codingtest.level2.BFS

import java.util.*

// 숫자 변환하기
class NumberConvert {
    fun solution(x: Int, y: Int, n: Int): Int {

        val q: Queue<Int> = LinkedList()
        val visited = hashSetOf<Int>()
        val count: Queue<Int> = LinkedList()

        q.add(x)
        count.add(0)

        while (q.isNotEmpty()) {
            val num = q.poll()!!
            val c = count.poll()!!

            if (num == y) {
                return c
            }

            if (num > y) {
                continue
            }


            val list = listOf("*3", "*2", "+$n")
            for (i in list) {
                var newX = num
                if (i == "*3") {
                    newX *= 3
                } else if (i == "*2") {
                    newX *= 2
                } else if (i == "+$n") {
                    newX += n
                }
                if (visited.contains(newX)) {
                    continue
                }
                visited.add(newX)
                q.add(newX)
                count.add(c + 1)
            }
        }
        return -1
    }
}

fun main() {
    val numberConvert = NumberConvert()
//    println(numberConvert.solution(10, 40, 5))
    println(numberConvert.solution(2, 100, 3))
//    println(numberConvert.solution(2, 5, 4))

}