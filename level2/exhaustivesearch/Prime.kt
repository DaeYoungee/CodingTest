package com.example.codingtest.level2.exhaustivesearch

// 소수 찾기
class Prime {

    var list = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        var answer = 0

        numbers.forEachIndexed { i, c ->
            recursion(
                c.toString(),
                numbers.filterIndexed { index, c -> index != i }
            )
        }
        println("list : $list")

        list.forEach {
            if (find(it)) {
                answer++
            }
        }
        return answer
    }

    fun recursion(number: String, remain: String) {
        list.add(number.toInt())

        if (remain.isEmpty()) return


        remain.forEachIndexed { i, c ->
            recursion("$number$c", remain.filterIndexed { index, c -> i != index })
        }
    }

    // 소수 찾기
    fun find(n: Int): Boolean = n > 1 && (2 until n).none { n % it == 0 }
}


fun main() {
    val prime = Prime()
    println(prime.solution("17"))

}