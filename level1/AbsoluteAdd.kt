package com.example.codingtest.level1

// 음양 더하기
class AbsoluteAdd {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {

        return absolutes.foldIndexed(0) { index, acc, i ->
            if (signs[index]) {
                acc + i
            } else {
                acc - i
            }
        }
    }
}

fun main() {
    println(AbsoluteAdd().solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true)))
}