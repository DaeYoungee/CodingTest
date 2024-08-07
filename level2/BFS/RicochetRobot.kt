package com.example.codingtest.level2.BFS

import java.util.LinkedList
import java.util.Queue

// 리코쳇 로봇
/* DFS 풀이 -> 시간 초과
class RicochetRobot {
    var answer: Int = 0
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)
    val directionList = listOf("up", "down", "left", "right")

    fun walk(
        board: Array<String>,                   // 전체 좌표
        position: Pair<Int, Int>,               // 현재 위치
        passed: List<Pair<Int, Int>>,           // 지나온 좌표
        count: Int = 0,                         // 경로 지날 때마다 1씩 증가
        prevDirection: String = "",             // 이전 방향
    ) {
        println("position: $position, \npassed: $passed, \ncount: $count, \nprevDirection: $prevDirection")
        // 현재 위치가 지나온 좌표에 포함된다(똑같은 경로를 지남)
        if (position in passed) {
            return
        }

        // 이미 goal를 지난 최소 경로보다 현재 count가 더 많은 경우
        if (answer != 0 && count >= answer) {
            return
        }

        // goal를 지난 경우
        if (board[position.first][position.second] == 'G') {
            answer = count
            return
        }


        for ((index, direction) in directionList.withIndex()) {
            when (direction) {
                directionList[0] -> {
                    if (prevDirection == directionList[1]) continue
                }

                directionList[1] -> {
                    if (prevDirection == directionList[0]) continue
                }

                directionList[2] -> {
                    if (prevDirection == directionList[3]) continue
                }

                directionList[3] -> {
                    if (prevDirection == directionList[2]) continue
                }
            }

            var currentPosition = position

            while (true) {
                // board, 전체 좌표의 범위를 벗어나는지 확인
                if (currentPosition.first + dy[index] !in board.indices || currentPosition.second + dx[index] !in board[0].indices) {
                    break
                }
                // 벽에 부딪히는지 확인
                if (board[currentPosition.first+dy[index]][currentPosition.second+dx[index]] == 'D') {
                    break
                }
                currentPosition = currentPosition.first + dy[index] to currentPosition.second + dx[index]
            }
            val newPassed = passed + position
            if (position != currentPosition) {
                walk(board, currentPosition, newPassed, count + 1, direction)
            }

        }
    }


    fun solution(board: Array<String>): Int {
        var position = -1 to -1
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 'R') {
                    position = i to j
                }
            }
        }
        walk(board, position, emptyList(), 0)

        if (answer == 0) return -1
        return answer
    }
}
 */

// BFS 풀이 -> 시간 초과
class RicochetRobot {
    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        val dx = arrayOf(0, 0, -1, 1)
        val dy = arrayOf(-1, 1, 0, 0)
        val directionList = listOf("up", "down", "left", "right")

        // 현재 위치를 저장한 queue
        val q: Queue<Pair<Int, Int>> = LinkedList()
        // 이전에 이동한 방향을 저장한 queue
        val historyDirection: Queue<String> = LinkedList()
        // 칸을 이동한 횟수
        val count: Queue<Int> = LinkedList()
        // 이전에 이동한 좌표를 저장한 queue
        val historyPosition: Queue<Pair<Int, Int>> = LinkedList()

        for (i in board.indices) {
            val index = board[i].indexOf('R')
            if (index != -1) {
                q.add(i to index)
                historyDirection.add("")
                count.add(0)
            }
        }

        while (q.isNotEmpty()) {
            val currentPosition = q.poll()!!
            val c = count.poll()!!
            val recentDirection = historyDirection.poll()

            // 이미 지나간 좌표 인지 확인
            if (historyPosition.contains(currentPosition)) continue
            else historyPosition.add(currentPosition)

            // 목표 지점에 도달 했는지 확인
            if (board[currentPosition.first][currentPosition.second] == 'G') {
                answer = c
                break
            }

            for ((index, direction) in directionList.withIndex()) {

                var newPosition = currentPosition

                when (direction) {
                    directionList[0] -> {
                        if (recentDirection == directionList[1]) continue
                    }

                    directionList[1] -> {
                        if (recentDirection == directionList[0]) continue
                    }

                    directionList[2] -> {
                        if (recentDirection == directionList[3]) continue
                    }

                    directionList[3] -> {
                        if (recentDirection == directionList[2]) continue
                    }
                }

                while (true) {
                    // board, 전체 좌표의 범위를 벗어나는지 확인
                    if (newPosition.first + dy[index] !in board.indices || newPosition.second + dx[index] !in board[0].indices) {
                        break
                    }
                    // 벽에 부딪히는지 확인
                    if (board[newPosition.first+dy[index]][newPosition.second+dx[index]] == 'D') {
                        break
                    }
                    newPosition = newPosition.first + dy[index] to newPosition.second + dx[index]
                }

                if (currentPosition == newPosition) continue
                else {
                    q.add(newPosition)
                    historyDirection.add(direction)
                    count.add(c + 1)
                }

            }

        }
        if(answer == 0) return -1
        return answer
    }
}

fun main() {
    println(
        RicochetRobot().solution(
            arrayOf(
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
            )
        )
    )

//    println(
//        RicochetRobot().solution(
//            arrayOf(
//                "D.R",
//                ".G.",
//                ".D."
//            )
//        )
//    )

//    println(
//        RicochetRobot().solution(arrayOf(".D.R", "....", ".G..", "...D"))
//    )


}