package com.example.codingtest.level1

// 약수 더하기
class MeasureAdd {
    fun solution(n: Int): Int {
        var i = 1
        var measureList = mutableListOf<Int>()
        while (i*i <= n) {
            if (n % i == 0 && i*i == n) {
                measureList.add(i)
            } else if (n % i == 0) {
                measureList.add(i)
                measureList.add(n / i)
            }
            i++
        }

        println(measureList)
        return if (measureList.isEmpty()) 0 else measureList.sum()
    }
}

fun main() {
    println(MeasureAdd().solution(12))
}