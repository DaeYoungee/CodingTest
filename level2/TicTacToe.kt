package com.example.codingtest.level2

class TicTacToe {
    fun solution(board: Array<String>): Int {
        val oCount = board.fold(0) { acc, str ->
            acc + str.count { it == 'O' }
        }
        val xCount = board.fold(0) { acc, str ->
            acc + str.count { it == 'X' }
        }
        var isOBingo = false
        var isXBingo = false

        val o = board.mapIndexed { row, s ->
            s.mapIndexed { col, c -> arrayOf(row, col) to c }.filter { it.second == 'O' }
        }.flatten()
        val x = board.mapIndexed { row, s ->
            s.mapIndexed { col, c -> arrayOf(row, col) to c }.filter { it.second == 'X' }
        }.flatten()
        x.forEach {
            println("${it.first.contentToString()}")
        }

        // 2차원 배열의 주 대각선에 위치하는지 확인
        if (o.count { it.first[0] == it.first[1]} == board.size) {
            isOBingo = true
        } else if (o.count { it.first[0] + it.first[1] == board.size - 1 } == board.size) { // 2찬원 배열의 부 대각선에 위치하는지 확인
            isOBingo = true
        }

        if (x.count { it.first[0] == it.first[1] } == board.size) {
            isXBingo = true
        } else if (x.count { it.first[0] + it.first[1] == board.size - 1 } == board.size) {
            isXBingo = true
        }

        else {
            for (i in board.indices) {
                if (o.count { it.first[0] == i } == board.size) {
                    isOBingo = true
                } else if (o.count { it.first[1] == i } == board.size) {
                    isOBingo = true
                }
                if (x.count { it.first[0] == i } == board.size) {
                    isXBingo = true
                } else if (x.count { it.first[1] == i } == board.size) {
                    isXBingo = true
                }
            }
        }

        if (oCount-xCount !in 0..1) {
            println("case1")
            return 0
        }
        if (isOBingo && !isXBingo && oCount-xCount != 1) {
            println("case2")
            return 0
        }
        if (!isOBingo && isXBingo && oCount != xCount) {
            println("case3")
            return 0
        }
        if (isOBingo && isXBingo) {
            println("case4")
            return 0
        }
        return 1
    }
}

/*
return = -1이 되는 case
1. O의 개수 보다 X의 개수가 더 많을 때
2. O의 개수가 X의 개수 보다 2개 이상 더 많을 때
3. O와 X의 개수 모두 3개씩인 경우(가로, 세로, 대각선이 같은 모댱으로 전부 매꿔져 있어야 함) -> O와 X 모두 빙고인 경우
//4. O만 빙고인 경우 -> 이미 게임이 끝나 있어야 함
//5. X만 빙고인 경우 -> 이미 게임이 끝나 있어야 함
 */

fun main() {
//    TicTacToe().solution(arrayOf("O.X", ".O.", "..X"))
//    println(TicTacToe().solution(arrayOf("OOO", "...", "XXX")))
//    // 반례1, 기댓값: 0
//    println(TicTacToe().solution(arrayOf("XXO", ".OX", "O..")))
//    // 반례2, 기댓값: 0
//    println(TicTacToe().solution(arrayOf("OXO", "XOX", "OXO")))
//    // 반례3, 기댓값: 0
//    println(TicTacToe().solution(arrayOf("OXO", ".OX", "OXX")))

}