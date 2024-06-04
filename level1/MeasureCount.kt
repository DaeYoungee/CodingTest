package com.example.codingtest.level1

class MeasureCount {
    fun solution(left: Int, right: Int): Int =
        (left..right).fold(0) { sum, num ->
            var count = 0
            var n = 1
            while (n * n <= num) {
                if (n * n++ == num) count++
                else count += 2
            }
            if (count % 2 == 0) sum + num
            else sum - num
        }

    /* 풀이 2
    fun solution(left: Int, right: Int): Int {
        return (left..right).map { i -> if ((1..i).filter { i % it == 0 }.size % 2 == 0) i else -i }.sum(
    }
     */

}

fun main() {
    println(MeasureCount().solution(13, 17))
}