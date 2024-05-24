package com.example.codingtest.level1

import java.util.Stack

class MakeHamburger {
    fun solution(ingredient: IntArray): Int {
        val stack = Stack<Int>()
        var answer: Int = 0

        ingredient.forEach { i ->
            stack.push(i)
            if (i == 1 && stack.size >= 4) {
                if (stack[stack.lastIndex -1] == 3 && stack[stack.lastIndex -2] == 2 && stack[stack.lastIndex -3] == 1) {
                    repeat(4) {
                        stack.pop()
                    }
                    answer++
                }
            }
        }
        return answer

    }
}



fun main() {
    println(MakeHamburger().solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(MakeHamburger().solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
    println(MakeHamburger().solution(intArrayOf(1, 2, 3, 1, 1, 2, 3, 1)))
}