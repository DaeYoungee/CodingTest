package com.example.codingtest.level1

import java.util.Locale

class NewIdRecommend {
    fun solution(new_id: String): String {

        var step2 = new_id.toLowerCase(Locale.ROOT)
            .filter { it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.' }
        while (step2.contains("..")) {
            step2 = step2.replace("..", ".")
        }
        if (step2[0] == '.') {
            step2 = step2.substring(1)
        }
        if (step2.isNotEmpty() && step2.last() == '.') {
            step2 = step2.substring(0, step2.length - 1)
        }
        if (step2.isEmpty()) {
            step2 = "a"
        }
        if (step2.length >= 16) {
            step2 = step2.substring(0, 15)
        } else if (step2.length <= 2) {
            while (step2.length < 3) {
                step2 += step2.last()
            }
        }
        if (step2[0] == '.') {
            step2 = step2.substring(1)
        }
        if (step2.isNotEmpty() && step2.last() == '.') {
            step2 = step2.substring(0, step2.length - 1)
        }
        return step2
    }
}

fun main() {
//    println(NewIdRecommend().solution("...!@BaT#*..y.abcdefghijklm"))
//    println(NewIdRecommend().solution("z-+.^."))
    println(NewIdRecommend().solution("=.="))
    println(NewIdRecommend().solution("123_.def"))
    println(NewIdRecommend().solution("abcdefghijklmn.p"))


}