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


fun main() {
//    println(Babbling().solution(arrayOf("aya", "yee", "u", "maa")))
    println(Babbling().solution(arrayOf("ayaye", "yeayaye", "yeye", "yemawoo", "ayaayaa")))
//    println(Babbling().solution(arrayOf("yayae")))


}