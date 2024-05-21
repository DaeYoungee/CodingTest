package com.example.codingtest.level1

fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val scoreArray = IntArray(photo.size) {0}
    val hashMap = hashMapOf<String, Int>()
    name.forEachIndexed { index, string ->
        hashMap.put(string, yearning[index])
    }
    photo.forEachIndexed { index, array ->
        array.forEach { string ->
            scoreArray[index] += hashMap[string] ?: 0
        }
    }
    return scoreArray
}

fun main() {
    val result = solution(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(arrayOf("may", "kein", "kain", "radi"), arrayOf("may", "kein", "brin", "deny"), arrayOf("kon", "kain", "may", "coni"))
    )
    println(result.contentToString())
}