package com.example.codingtest.introduction

import kotlin.math.sqrt

class Measure {
    // 1부터 n까지 전부 순회함
    //    fun solution(n: Int) = (1..n).filter { n % it == 0 }
    // 약수는 n의 제곱근까지만 순회하면 돼, ex) n = 16일 때 우리는 1~4까지만 약수를 확인하면 돼
    fun solution(n: Int): IntArray {
        var measureList = mutableListOf<Int>()
        (1..sqrt(n.toDouble()).toInt()).forEach {
            if (n % it == 0) {
                if (n / it == it) {
                    measureList.add(it)
                } else {
                    measureList.add(it)
                    measureList.add(n/it)
                }
            }
        }
        return measureList.sorted().toIntArray()
    }

}

fun main() {
    println(Measure().solution(100).contentToString())
}