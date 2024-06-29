package com.example.codingtest.introduction

// 소수 판별하기
class Prime {
    private fun isPrime(n: Int): Boolean {
        if (n == 0 || n == 1) return false
        var i = 2
        while (i * i <= n) {
            if (n % i++ == 0) return false
        }
        return true
    }
}