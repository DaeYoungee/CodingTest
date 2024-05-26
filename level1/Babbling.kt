package com.example.codingtest.level1

class Babbling {
    fun solution(babbling: Array<String>) = babbling.fold(0) { sum, str ->
        var babblings = str
        val pattern = arrayOf("aya", "ye", "woo", "ma")

        for (i in pattern) {
            if (babblings.contains(i + i)) {
                continue
            } else {
                babblings = babblings.replace(i, " ")
            }
        }
        babblings = babblings.replace(" ", "")
        if (babblings.isEmpty()) {
            return@fold sum + 1
        } else {
            return@fold sum
        }
    }
    // -----> Good Cord
    fun solution2(babbling: Array<String>): Int {
        val ableRegex = "aya|ye|woo|ma".toRegex()
        val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex()
        return babbling.count() {
            !it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
        }
    }
    // <-----
}

/* 깨달은 점
1. 문자열에서 찾아야 할 pattern 과 찾지 말아야 할 pattern 이 존재한다면 배열로 만들어 접근해보자.
    --> 무턱대로 처음부터 문자를 찾지말자.
2. 문자열에서 pattern 을 찾을 경우 정규식을 이용해보자. 훨씬 빠르다.(solution2)

*/

fun main() {
//    println(Babbling().solution(arrayOf("aya", "yee", "u", "maa")))
    println(Babbling().solution(arrayOf("ayaye", "yeayaye", "yeye", "yemawoo", "ayaayaa")))
//    println(Babbling().solution(arrayOf("yayae")))
}
