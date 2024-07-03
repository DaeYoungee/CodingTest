package com.example.codingtest.level2

// 리코쳇 로봇
class RicochetRobot {
    fun walk(
        position: List<Pair<Int, Int>>,
        road: List<Pair<Int, Int>>,
        obstacle: List<Pair<Int, Int>>,
        goal: Pair<Int, Int>,
        walls: Pair<Int, Int>,
        count: Int = 0,
        prevDirection: String = "",
    ): Int {
        println("position: $position, count: $count")

        val list = listOf(
            goal.first + 1 to goal.second,
            goal.first - 1 to goal.second,
            goal.first to goal.second + 1,
            goal.first to goal.second - 1
        )

        // 목표 위치에 도달할 수 없는 case 2가지
        if (list.all { it in obstacle } ) return -1
        else if (list.all { it in road } ) return -1

        // 목표 위치 도달
        if (position.last() == goal) {
            return count
        }

        val test = listOf("up", "down", "left", "right").map { direction ->
//            println("direction: $direction")
            if (direction == "up" && position.last().first > 0 && (position.last().first - 1 to position.last().second) !in obstacle && prevDirection != "up" && prevDirection != "down") {
                val changedPositionList = obstacle.filter { it.second == position.last().second && it.first < position.last().first }
                val changedPosition = if (changedPositionList.isEmpty()) {
                    0 to position.last().second
                } else {
                    val wall = changedPositionList.minByOrNull { it.second }

                    wall!!.first + 1 to wall.second
                }
                if (changedPosition in position.slice(1 until position.size - 1)) {
                    Int.MAX_VALUE
                } else {
                    walk(position + changedPosition, road, obstacle, goal, walls, count + 1, "up")
                }
            } else if (direction == "down" && position.last().first < walls.first - 1 && (position.last().first + 1 to position.last().second) !in obstacle && prevDirection != "down" && prevDirection != "up") {

                val changedPositionList = obstacle.filter { it.second == position.last().second && it.first > position.last().first}
                val changedPosition = if (changedPositionList.isEmpty()) {
                    walls.first -1 to position.last().second
                } else {
                    val wall = changedPositionList.maxByOrNull { it.second }
                    wall!!.first - 1 to wall.second
                }
                if (changedPosition in position.slice(1 until position.size - 1)) {
                    Int.MAX_VALUE
                } else {
                    walk(position + changedPosition, road, obstacle, goal, walls, count + 1, "down")
                }
            } else if (direction == "left" && position.last().second > 0 && (position.last().first to position.last().second - 1) !in obstacle && prevDirection != "left" && prevDirection != "right") {
                val changedPositionList = obstacle.filter { it.first == position.last().first && it.second < position.last().second}
                val changedPosition = if (changedPositionList.isEmpty()) {
                    position.last().first to 0
                } else {
                    val wall = changedPositionList.minByOrNull { it.first }
                    wall!!.first to wall.second + 1
                }
                if (changedPosition in position.slice(1 until position.size - 1)) {
                    Int.MAX_VALUE
                } else {
                    walk(position + changedPosition, road, obstacle, goal, walls, count + 1, "left")
                }
            } else if (direction == "right" && position.last().second < walls.second - 1 && (position.last().first to position.last().second + 1) !in obstacle && prevDirection != "right" && prevDirection != "left") {
                val changedPositionList = obstacle.filter { it.first == position.last().first && it.second > position.last().second}
                val changedPosition = if (changedPositionList.isEmpty()) {
                    position.last().first to walls.second-1
                } else {
                    val wall = changedPositionList.maxByOrNull { it.first }
                    wall!!.first to wall.second -1
                }
                if (changedPosition in position.slice(1 until position.size - 1)) {
                    Int.MAX_VALUE
                } else {
                    walk(position + changedPosition, road, obstacle, goal, walls, count + 1, "right")
                }
            } else {
                println("길 없음")
                Int.MAX_VALUE
            }
        }

        println("test: $test")
        return test.minOf { it }
//        return 0
    }

    fun solution(board: Array<String>): Int {
        val list = board
            .map { it.toList() }
            .mapIndexed { index1, chars ->
                chars.mapIndexed { index2, c ->
                    c to Pair(index1, index2)
                }
            }.flatten()
        val position = list.filter { it.first == 'R' }.associate { it }.values.first()
        val road = list.filter { it.first == '.' || it.first == 'R' }.map { it.second }
        val obstacle = list.filter { it.first == 'D' }.map { it.second }
        val goal = list.filter { it.first == 'G' }.associate { it }.values.first()
        val wall = board.size to board[0].length

//        println("list: $list")
//        println("position: $position")
//        println("road: $road")
//        println("obstacle: $obstacle")
//        println("goal: $goal")
//        println("wall: $wall")

//        walk(position, road, obstacle, goal, wall)

        var answer: Int = 0
        return walk(listOf(position), road, obstacle, goal, wall)
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