package com.example.codingtest.level1

fun solution4(park: Array<String>, routes: Array<String>): IntArray {
    val moveX = hashMapOf("N" to 0, "S" to 0, "E" to 1, "W" to -1)
    val moveY = hashMapOf("N" to -1, "S" to 1, "E" to 0, "W" to 0)
    var maxX = park[0].length - 1
    var maxY = park.size - 1
    println("maxX: $maxX, maxY: $maxY")
    var currentPosition: Pair<Int, Int> = 0 to 0

    // 현재 위치 초기화
    for (i in park.indices) {
        for (j in park[i].indices) {
            if (park[i][j] == 'S') {
                currentPosition = i to j
            }
        }
    }


    routes.forEachIndexed { index, route ->
        val split = route.split(" ")

        var x = currentPosition.second  // 열
        var y = currentPosition.first   // 행


        for (i in 0 until split[1].toInt()) {

            x += moveX[split[0]]!!
            y += moveY[split[0]]!!
            println("열: $x, 행: $y")

            // 문제에서 주어진 표를 벗어나면 안되게끔 설정!git
            if (y !in 0 .. maxY || x !in 0 .. maxX || park[y][x] == 'X') {
                x = currentPosition.second
                y = currentPosition.first
                println("break")
                break
            }
        }

        currentPosition = y to x
        println(currentPosition)

    }

    var answer: IntArray = intArrayOf(currentPosition.first, currentPosition.second)
    return answer
}

fun main() {
    val result = solution4(
//        arrayOf("SOO","OOO","OOO"),
//        arrayOf("E 2","S 2","W 1")
//        arrayOf("SOO","OXX","OOO"),
//        arrayOf("E 2","S 2","W 1"),
        arrayOf("OSO","OOO","OXO","OOO"),
        arrayOf("E 2","S 3","W 1")

    )
    println(result.contentToString())
}
