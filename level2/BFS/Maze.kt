package com.example.codingtest.level2.BFS

import java.util.LinkedList
import java.util.Queue

// 미로 탈출
// 풀이: 출발지 -> 레버로 가는 bfs와 레버 -> 도착지로 가는 bfs로 총 2개의 bfs로 이루어져야 함
class Maze {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0

        val (time, switch) = bfs(maps, 'S', 'L')
        if (switch) {
            answer += time
            val (time1, switch2) = bfs(maps, 'L', 'E')
            if (switch2) {
                answer += time1
                return answer
            } else {
                return -1
            }
        } else {
            return -1
        }
    }

    fun bfs(maps: Array<String>, start: Char, goal: Char): Pair<Int, Boolean> {
        val dx = arrayOf(0, 0, -1, 1)
        val dy = arrayOf(-1, 1, 0, 0)
        val directionList = listOf("up", "down", "left", "right")

        val q: Queue<Pair<Int, Int>> = LinkedList()
        val time: Queue<Int> = LinkedList()
        val historyDirection: Queue<String> = LinkedList()
        val historyPosition: Queue<Pair<Int, Int>> = LinkedList()


        for (i in maps.indices) {
            val index = maps[i].indexOf(start)
            if (index != -1) {
                q.add(Pair(i, index))
                time.add(0)
                historyDirection.add("")
                break
            }
        }

        while (q.isNotEmpty()) {
            val position = q.poll()!!
            val t = time.poll()!!
            val recentDirection = historyDirection.poll()!!

            // 이미 지나간 좌표인지 확인
            if (historyPosition.contains(position)) continue
            else historyPosition.add(position)

            // 목표지점(레버 or 도착지)에 도착하면 bfs 함수 탈출
            if (maps[position.first][position.second] == goal) {
                return t to true
            }

            //(up, down, left, right) 총 4방향의 이동 가능한 경우의 수
            for ((index, direction) in directionList.withIndex()) {
                var newPosition = position

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

                // 1번째 if문 map의 범위를 벗어나는지 확인
                // else if문 벽에 부딪히는지 확인
                if (newPosition.first + dy[index] < 0 || newPosition.first + dy[index] >= maps.size
                    || newPosition.second + dx[index] < 0 || newPosition.second + dx[index] >= maps[0].length
                ) {
                    continue
                } else if (maps[newPosition.first + dy[index]][newPosition.second + dx[index]] == 'X') {
                    continue
                } else {
                    newPosition =
                        Pair(newPosition.first + dy[index], newPosition.second + dx[index])
                }
                historyDirection.add(direction)
                q.add(newPosition)
                time.add(t + 1)
            }

        }
        return -1 to false
    }
}

fun main() {
    println(
        Maze().solution(
            arrayOf(
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
            )
        )
    )
//    println(
//        Maze().solution(
//            arrayOf(
//                "SELOX",
//                "XXXXO",
//                "OOOOO",
//                "OXXXX",
//                "OOOOO"
//            )
//        )
//    )
//    println(
//        Maze().solution(
//            arrayOf(
//                "LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"
//            )
//        )
//    )
}