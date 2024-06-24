package com.example.codingtest.level1

import java.util.Stack

// 크레인 인형 뽑기 게임
class CrainDraw {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()
        var answer = 0
        moves.forEach { crain ->
            for (i in 0.. board.lastIndex) {
                val data = board[i][crain-1]
                if (data != 0) {
                    if (stack.isNotEmpty() && stack.peek() == data) {
                        stack.pop()
                        answer+=2
                    } else {
                        stack.push(data)
                    }
                    board[i][crain-1] = 0
                    break
                }
            }
        }



        return answer
    }
}

fun main() {
    println(
        CrainDraw().solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1),
            ),
            intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}