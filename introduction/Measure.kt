package com.example.codingtest.introduction

class Measure {
    fun solution(n: Int) = (1..n).filter { n % it == 0 }
}

fun main() {
    println(Measure().solution(100))
}