package com.example.codingtest.level1

// 없는 숫자 더하기
class NotNumberAdd {
    fun solution(numbers: IntArray): Int =
        (0..9).filterNot { numbers.contains(it) }.sum()
    // 아래의 코드도 가능
    //    (0..9).filterNot(numbers::contains).sum()

}

fun main() {
    println(NotNumberAdd().solution(intArrayOf(1,2,3,4,6,7,8,0)))
}