package com.example.codingtest.level2

// 숫자 카드 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/135807
class NumberCard {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer = 0
        var gcdA = arrayA[0]
        var gcdB = arrayB[0]

        // 각 배열의 최대공약수 구하기
        for (i in 1 until arrayA.size) {
            gcdA = GCD(gcdA, arrayA[i])
            gcdB = GCD(gcdB, arrayB[i])
        }

        if (arrayB.all { it % gcdA != 0 }) {
            answer = Math.max(answer, gcdA)
        }
        if (arrayA.all { it % gcdB != 0 }) {
            answer = Math.max(answer, gcdB)
        }
        return answer

    }

    // 최대공약수 구하는 메소드
    fun GCD(a: Int, b: Int): Int {
        if (a % b == 0) return b
        return GCD(b, a % b)
    } // End of GCD


//    // 최소 공약수
//    fun commonDivisor(arr: IntArray): IntArray {
//        // arr[0]의 약수
//        val measure = mutableSetOf<Int>()
//
//        var i = 1
//        while (i*i < arr[0]) {
//            if (arr[0] % i == 0) {
//                measure.add(i)
//                measure.add(arr[0] / i)
//            }
//            i++
//        }
//
//        var order = 1
//        while (order < arr.size) {
//            val commonMeasure = measure.toList()
//            for (i in commonMeasure) {
//                if (arr[order] % i != 0) {
//                    measure.remove(i)
//                }
//            }
//            order++
//        }
//        measure.remove(1)
//        return measure.toIntArray()
//    }
}

fun main() {
    val numberCard = NumberCard().solution(intArrayOf(5), intArrayOf(2))
    println(numberCard)
}