package com.example.codingtest.level1

import kotlin.math.sqrt

class WeaponOfKnight {
    /* 나의 풀이
    fun solution(number: Int, limit: Int, power: Int) = (1..number).map { num ->
        val result = measure(num).size
        if (result > limit) power
        else result
    }.sum()

    fun measure(n: Int):List<Int> {
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
        return measureList.sorted()
    }
     */

    // <------ 좋은 풀이 예시
    fun solution(number: Int, limit: Int, power: Int): Int {
        return IntArray(number) { getCount(it + 1) }.fold(0) { acc, v ->
            if (v > limit) acc + power
            else acc + v
        }
    }

    private fun getCount(n: Int): Int {
        var count = 0
        var i = 1
        while (i * i < n) {
            if (n % i++ == 0) count += 2
        }
        if (i * i == n) count++
        return count
    }
    // ------>

    fun test() {
        val list = IntArray(3)
        println(list.contentToString())
    }
}

/* 깨달은 점
1. 약수를 구할 때 제곱근을 이용해서 구하면 것이 n 값이 큰 경우에는 더 빠른 시간내에 해결 가능하다.
    n 값이 작은 경우 1~n까지 빠르게 순회하는 것이 빠를 수 있음
2. 약수의 개수만 필요한 경우 굳이 약수를 리스트에 저장하고 개수를 구하지 말고 곧 바로 개수를 구하자!
3. list의 조건식을 달아 일부만 더하고 싶을 case나 값을 변형해서 더하고 싶을 경우 sum() 보다 fold()를 이용하자!

*/

fun main() {
    println(WeaponOfKnight().solution(5, 3, 2))
    println(WeaponOfKnight().test())
}