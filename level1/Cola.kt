package com.example.codingtest.level1

class Cola {
    fun solution(a: Int, b: Int, n: Int): Int {
        var filledBottle = n
        var receivedBottle = 0
        while (filledBottle >= a) {
            receivedBottle += (filledBottle/a) * b
            filledBottle = filledBottle%a + (filledBottle/a) * b
        }
        return receivedBottle
    }
}

fun main() {
    println(Cola().solution(2, 1, 20))
    println(Cola().solution(3, 1, 20))
}