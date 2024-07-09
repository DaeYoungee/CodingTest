package com.example.codingtest.level2.greedy


// 당구 연습
// x축 or y축 대칭을 통해 문제 해결
class Billiards {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        return balls.map {arr -> 
            // x 값이 동일한 경우
            if (arr[0] == startX) {
                // 우측 끝 y축 대칭
                val d1 = pow(startY - arr[1]) + pow(2*(m-startX))
                // 좌측 y축 대칭
                val d2 = pow(startY - arr[1]) + pow(startX*2)
                val d3 = if (startY > arr[1]) { pow(2*(n-startY)+startY-arr[1]) } else { pow(startY + arr[1]) }
                listOf(d1, d2, d3).minOf { it }

            } else if (arr[1] == startY) {
                // 상단 끝 x축 대칭
                val d1 = pow(startX - arr[0]) + pow(2*(n-startY))
                // 하단 x축 대칭
                val d2 = pow(startX - arr[0]) + pow(startY*2)
                val d3 = if (startX > arr[0]) { pow(2*(m-startX)+startX-arr[0]) } else { pow(startX + arr[0]) }
                listOf(d1, d2, d3).minOf { it }
            } else {
                // 좌측 y축 대칭
                val d1 = pow(startX+arr[0]) + pow(startY - arr[1])
                // 우측 y축 대칭
                val d2 = pow(2*m - (startX+arr[0])) + pow(startY - arr[1])
                // 상단 x축 대칭
                val d3 = pow(startX - arr[0]) + pow(2*n - (startY+arr[1]))
                // 하당 x축 대칭
                val d4 = pow(startX - arr[0]) + pow(startY+arr[1])
                listOf(d1, d2, d3, d4).minOf {it}
            }
        }.toIntArray()
    }

    fun pow(n1: Int): Int =
        n1*n1

}


fun main() {
    println(
        Billiards().solution(
            10,
            10,
            3,
            7,
            arrayOf(intArrayOf(7, 7), intArrayOf(2, 7), intArrayOf(7, 3))
        ).contentToString()
    )
}