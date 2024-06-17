package com.example.codingtest.level1

class DotProduct {
    //    fun solution(a: IntArray, b: IntArray): Int {
//        var sum = 0
//        for (i in a.indices) {
//            sum += a[i] * b[i]
//        }
//        return sum
//    }
    fun solution(a: IntArray, b: IntArray): Int {
        println(a.zip(b))    // [(1, -3), (2, -1), (3, 0), (4, 2)] 처럼 List<Pair<Int, Int>>로 묶임
        return a.zip(b).sumOf { it.first * it.second }
    }
}

fun main() {
    println(DotProduct().solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))
}