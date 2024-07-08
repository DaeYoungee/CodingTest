package com.example.codingtest.level2.BFS

import java.util.*

// 무인도 여행
class UninhabitedIsland {
    val result = mutableListOf<Int>()

    fun solution(maps: Array<String>): IntArray {

        val visited = hashSetOf<Pair<Int, Int>>()

        for (i in maps.indices) {
            for (j in maps[i].indices) {
                if (maps[i][j] == 'X') continue

                if (visited.contains(i to j)) continue
                else visited.add(i to j)

                bfs(maps, i, j, visited)
            }
        }
        if (result.isEmpty()) return intArrayOf(-1)
        return result.sorted().toIntArray()
    }

    fun bfs(maps: Array<String>, row: Int, col: Int, visited: MutableSet<Pair<Int, Int>>) {
        val directionList = listOf("up", "down", "left", "right")
        val dx = listOf(0, 0, -1, 1)
        val dy = listOf(-1, 1, 0, 0)

        val q: Queue<Pair<Int, Int>> = LinkedList()
        var sum = maps[row][col].toString().toInt()

        q.add(row to col)

        while (q.isNotEmpty()) {
            val (newRow, newCol) = q.poll()!!

            for ((index, direction) in directionList.withIndex()) {

                val nRow = newRow + dy[index]
                val nCol = newCol + dx[index]
                if (nRow < 0 || nRow >= maps.size || nCol < 0 || nCol >= maps[0].length) continue
                if (maps[nRow][nCol] == 'X') continue

                if (visited.contains(nRow to nCol)) continue

                q.add(nRow to nCol)
                sum += maps[nRow][nCol].toString().toInt()
                visited.add(nRow to nCol)
            }
        }
        result.add(sum)
    }
}

fun main() {
//    println(
//        UninhabitedIsland().solution(arrayOf("X591X", "X1X5X", "X231X", "1XXX1")).contentToString()
//    )
    println(
        UninhabitedIsland().solution(arrayOf("X591X", "X1X5X", "X231X", "1X3X1")).contentToString()
    )
}