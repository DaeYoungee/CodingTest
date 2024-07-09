package com.example.codingtest.level2

// 테이블 해쉬 함수
class HashFunc {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int =
         data.sortedWith(compareBy<IntArray> { it[col-1] }.thenByDescending { it[0] })
            .mapIndexed { index, arr ->
                val row = index+1
                if (row in row_begin..row_end) {
                    arr.fold(0) { acc, i -> acc + i % row }
                } else -1
            }.filterNot { it == -1 }
            .fold(0) { acc, i -> acc xor i }

}

fun main() {
    println(
        HashFunc().solution(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 0, 1, 0),
                intArrayOf(0, 1, 0, 1),
                intArrayOf(7, 7, 7, 7)
            ),
            2,
            2,
            3
        )
    )
}