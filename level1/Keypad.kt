package com.example.codingtest.level1

import kotlin.math.absoluteValue

// 키패드 누르기
class Keypad {
    fun solution(numbers: IntArray, hand: String): String {
        // *을 10, # 을 12로, 0을 11로 두는 문제에 핵심
        // 상하좌우로 움직일 떄 거리를 계산하는 식은 ((currentNum / 3) + (currentNum % 3)).absoluteValue과 같다.
        var currentLeftHand = 10
        var currentRightHand = 12
        return numbers.map {
            if (it == 1 || it == 4 || it == 7) {
                currentLeftHand = it
                "L"
            }
            else if (it == 3 || it == 6 || it == 9) {
                currentRightHand = it
                "R"
            }
            else {
                if (calculateDistance(currentLeftHand, it) > calculateDistance(currentRightHand, it)) {
                    currentRightHand = it
                    "R"
                } else if (calculateDistance(currentLeftHand, it) < calculateDistance(currentRightHand, it)) {
                    currentLeftHand = it
                    "L"
                } else {
                    if (hand == "left") {
                        currentLeftHand = it
                        "L"
                    } else {
                        currentRightHand = it
                        "R"
                    }
                }
            }
        }.fold("") { acc, s -> acc + s }
    }

    fun calculateDistance(current: Int, goal: Int): Int {
        var n = if (goal == 0) 11 else goal
        var currentN = if (current == 0) 11 else current
        val currentNum = currentN - n

        return ((currentNum / 3) + (currentNum % 3)).absoluteValue
    }
}

fun main() {
//    println(Keypad().solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
    println(Keypad().solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
//    println(Keypad().solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))


}