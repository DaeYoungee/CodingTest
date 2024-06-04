package com.example.codingtest.level1

class InsufficientAmount {
    fun solution(price: Int, money: Int, count: Int): Long =
        (1..count).fold(0L) { sum, count ->
            sum + count * price
        }.minus(money).let {
            if (it > 0) {
                it.toLong()
            } else {
                0
            }
        }


}

fun main() {
    println(InsufficientAmount().solution(3, 20, 4))
    println(InsufficientAmount().solution(2500, 4, 2500))


}