package com.example.codingtest.level1

class DivideString {
    fun solution(s: String): Int {

        var answer: Int = 0

        var subStr = s
        var x = subStr[0]
        var index = 0
        var xCount = 0
        var diffCount = 0
        while (subStr.isNotEmpty()) {
            x = subStr[0]
            if (x == subStr[index]) {
                xCount++
            } else {
                diffCount++
            }
            if (xCount == diffCount || subStr.lastIndex == index) {
                subStr = subStr.substring(index+1)
                answer++
                xCount = 0
                diffCount = 0
                index = 0
            } else {
                index++
            }
        }
        return answer
    }

    fun solution2(s: String): Int {
        var answer: Int = 0

        val stack = mutableListOf<Char>()

        s.forEach {
            if (stack.isEmpty()) {
                answer++
                stack.add(it)
            } else if (stack.first() == it) {
                stack.add(it)
            } else {
                stack.removeFirst()
            }
        }

        return answer
    }
}

fun main() {
//    println(DivideString().solution("banana"))
    println(DivideString().solution("abracadabra"))
    println(DivideString().solution("aaabbaccccabba"))


}