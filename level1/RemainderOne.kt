package com.example.codingtest.level1

class RemainderOne {
    fun solution(n: Int): Int {
        var answer: Int = 0
        /* repeat 반복문 이용
        run loop@ {
            repeat(n) {
                if (n % (it+1) == 1) {
                    answer = (it+1)
                    return@loop
                }
            }
        }
        */

        // for 반복문 이용
        for (i in 1..n) {
            if (n % (i+1) == 1) {
                answer = (i+1)
                break
            }
        }

        return answer
    }
}


fun main() {
    println(RemainderOne().solution(10))
    println(RemainderOne().solution(12))
}