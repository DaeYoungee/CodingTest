package com.example.codingtest.level1

class FoodFight {
    fun solution(food: IntArray): String {
        var foods: String = ""

        for (i in 1 until food.size) {
            repeat(food[i] / 2) {
                foods += i
            }
        }
        foods += 0

        for (i in foods.length - 2 downTo 0) {
            foods += foods[i]
        }
        return foods
    }
}


fun main() {
    println(FoodFight().solution(intArrayOf(1, 3, 4, 6)))
    println(FoodFight().solution(intArrayOf(1, 7, 1, 2)))
}