package com.example.codingtest.level1

// 두 개 뽑아서 더하기
class NumberSelectAdd {
    fun solution(numbers: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in numbers.indices) {
            for (j in i+1 until numbers.size) {
                val sum = numbers[i]+numbers[j]
                if (!result.contains(sum)) {
                    result.add(sum)
                }
            }
        }
        println(numbers.toList().withIndex().flatMap { i -> numbers.toList().withIndex().map { j -> i to j } })
        return result.sorted().toIntArray()
    }
}

fun main () {
    println(NumberSelectAdd().solution(intArrayOf(2,1,3,4,1)).contentToString())
    println(NumberSelectAdd().solution(intArrayOf(5,0,2,7)).contentToString())
}