package com.example.codingtest.aligorithm.dfs

import java.util.Stack

// 백준 1260번
class DFS1 {
    fun solution(input: String, relations: Array<String>): IntArray {
        val arr = input.split(" ").map { it.toInt() }
        val nodeCount = arr[0]
        val edges = arr[1]
        val start = arr[2]

        val stack = Stack<Int>()
        val history = mutableSetOf<Int>()
        stack.push(start)

        val answer = mutableListOf<Int>()


        val r = relations.map {
            val i = it.split(" ")
            i[0].toInt() to i[1].toInt()
        }

        while (stack.isNotEmpty()) {
            println("stack : $stack")
            val data = stack.pop()!!


            if (data in history) continue
            else history.add(data)
            answer.add(data)

            val list = r.filter { it.first == data }.sortedByDescending { it.second }

            for (i in list) {

                stack.push(i.second)
            }
        }
        println(answer)

        return answer.toIntArray()
    }
}

fun main() {
    DFS1().solution("4 5 1", arrayOf("1 2", "1 3", "1 4", "2 4", "3 4"))

}