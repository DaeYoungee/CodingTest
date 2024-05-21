package com.example.codingtest.level1


fun solution5(n: Int, m: Int, section: IntArray): Int {
    var endpoint = 0

    val count = section.fold(0) { count, index ->
        if (index > endpoint) {
            endpoint = index + m - 1
            count + 1
        } else {
            count
        }
    }
    return count
}

fun main() {
//    val result = solution5(4, 1, intArrayOf(1, 2, 3, 4))
    val result = solution5(8, 4, intArrayOf(2, 3, 6))
    println("result: $result")

}