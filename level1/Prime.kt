package com.example.codingtest.level1

// 소수 구하기
class Prime {
    fun solution(nums: IntArray): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    if (isPrime(sum)) {
                        count++
                    }
                }
            }
        }
        println()
        return count
    }

    private fun isPrime(n: Int): Boolean {
        if (n == 0 || n == 1) return false
        var i = 2
        while (i * i <= n) {
            if (n % i++ == 0) return false
        }
        return true
    }
}

fun main() {
    println(Prime().solution(intArrayOf(1, 2, 7, 6, 4)))
}