package com.example.codingtest.level1

// 숫자 문자열과 영단어 풀이
class NumberAndStringWord {
    fun solution(s: String): Int {
        var number = StringBuilder()
        var numberFormat = StringBuilder()
        val wordList = hashMapOf<String, String>(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9",
        )


        s.forEach {
            if (it in '0'..'9') {
                numberFormat.append(it)
            } else {
                number.append(it)
                if (number.length >= 3) {
                    if (wordList.contains(number.toString())) {
                        numberFormat.append(wordList[number.toString()])
                        number.clear()
                    }
                }
            }
        }
        return numberFormat.toString().toInt()
    }

    /*  간략한 코드
    fun solution(s: String): Int = s
        .replace("one", "1")
        .replace("two", "2")
        .replace("three", "3")
        .replace("four", "4")
        .replace("five", "5")
        .replace("six", "6")
        .replace("seven", "7")
        .replace("eight", "8")
        .replace("nine", "9")
        .replace("zero", "0")
        .toInt()
    */

}

fun main() {
    println(NumberAndStringWord().solution("one4seveneight"))
}