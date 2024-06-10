package com.example.codingtest.level1

import java.util.Locale

// 신규 아이디 추천
class NewIdRecommend {
    fun solution(new_id: String): String {

        var step2 = new_id.toLowerCase(Locale.ROOT)
            .filter { it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.' }
            .replace("[.]+".toRegex(), ".")
            .removePrefix(".")
            .removeSuffix(".")
            .let { if (it.isEmpty()) "a" else it }

        if (step2.length >= 16) {
            step2 = step2.substring(0, 15)
        } else if (step2.length <= 2) {
            while (step2.length < 3) {
                step2 += step2.last()
            }
        }
        return step2.removeSuffix(".")
    }
}

fun main() {
    println(NewIdRecommend().solution("...!@BaT#*..y.abcdefghijklm"))
    println(NewIdRecommend().solution("z-+.^."))
    println(NewIdRecommend().solution("=.="))
    println(NewIdRecommend().solution("123_.def"))
    println(NewIdRecommend().solution("abcdefghijklmn.p"))


}