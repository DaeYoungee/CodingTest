package com.example.codingtest.level1

class LeastRectangle {
    fun solution(sizes: Array<IntArray>): Int {

        var maxList = mutableListOf<Int>()
        var minList = mutableListOf<Int>()

        sizes.forEach {
            if (it[0] > it[1]) {
                maxList.add(it[0])
                minList.add(it[1])
            } else {
                maxList.add(it[1])
                minList.add(it[0])
            }
        }
        var answer: Int = maxList.maxOrNull()!! * minList.maxOrNull()!!

        return answer
    }
}


fun main() {
    println(LeastRectangle().solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))))
}