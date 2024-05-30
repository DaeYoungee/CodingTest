package com.example.codingtest.level1

class ThreeMusketeers {

    /* 실행속도 많이 느림
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for (i in 0 .. number.lastIndex - 2) {
            for (j in i + 1 .. number.lastIndex - 1) {
                for (k in j + 1 .. number.lastIndex) {
                    if (number[i]+number[j]+number[k] == 0) {
                        answer += 1
                    }
                }
            }
        }
        return answer
    }
    */

    // 실행속도 빠름
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for ((i,n) in number.withIndex()) {
            for ((j, m) in number.withIndex()) {
                for ((k, l) in number.withIndex()) {
                    if ((i < j) && (j < k)) {
                        if (n + m + l == 0) {
                            answer++
                        }
                    }
                }
            }
        }
        return answer
    }
}


fun main() {
    println(ThreeMusketeers().solution(intArrayOf(-2, 3,0,  2, -5)))
    println(ThreeMusketeers().solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3)))
    println(ThreeMusketeers().solution(intArrayOf(-1, 1, -1, 1)))


}