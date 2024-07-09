package com.example.codingtest.level2

import java.util.Stack

// 뒤에 있는 큰 수 찾기
class BigNumber {

    // 풀이 1. 2중 for문 + break
    // 시간 초과
    /*
    fun solution(numbers: IntArray): IntArray =
        numbers.mapIndexed { cur, i ->
            var newNum = i
            for (next in cur + 1 until numbers.size) {
                if (i < numbers[next]) {
                    newNum = numbers[next]
                    break
                }
            }
            if (newNum == i) {
                -1
            } else newNum
        }.toIntArray()
     */

    // 풀이 2. stack
    fun solution(numbers: IntArray): IntArray {
        var sIndex = 0
        val stack = Stack<Int>()
        val result = IntArray(numbers.size) { -1 }
        numbers.forEachIndexed { index, i ->
            while (sIndex <= index) {
                val stackLastIndex = if (stack.isNotEmpty()) stack.peek() else -1

                if (stack.isEmpty() || numbers[stackLastIndex] >= i) {
                    stack.add(index)
                    sIndex++
                } else {
                    result[stackLastIndex] = numbers[index]
                    stack.pop()
                }
            }
        }
        return result
    }

}

fun main() {
//    println(BigNumber().solution(intArrayOf(2, 3, 3, 5)).contentToString())

    println(BigNumber().solution(intArrayOf(9, 1, 5, 3, 6, 2)).contentToString())
}