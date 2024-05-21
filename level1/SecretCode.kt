package com.example.codingtest.level1

// 둘만의 암호
class SecretCode {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        val skipped = skip.map { it.toChar() }
        val alphabet = ('a'..'z').filter { it !in skipped }

        s.forEach {
            val i = (alphabet.indexOf(it) + index) % alphabet.size
            answer += alphabet[i]
        }
        return answer
    }

}


fun main() {
    val result = SecretCode().solution("aukks", "wbqd", 5)
    println(result)
}