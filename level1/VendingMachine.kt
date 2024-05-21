package com.example.codingtest.level1

import java.util.HashMap

class VendingMachine {
    val keyList = mutableListOf<HashMap<Char, Int>>()

    private fun keyInit(keymap: Array<String>) {
        for (i in keymap.indices) {
            keyList.add(hashMapOf())
        }

        for (i in keymap.indices) {
            for (j in 1..keymap[i].length) {
                if (!keyList[i].containsKey(keymap[i][j - 1])) {
                    keyList[i][keymap[i][j - 1]] = j
                }
            }
        }
        println("keyList: $keyList")
    }

    private fun mapCompare(keyList: List<HashMap<Char, Int>>, char: Char): Int {
        var minKey = 101
        for (i in keyList.indices) {
            keyList[i][char]?.let {
                if (it < minKey) minKey = it
            }
        }
        if (minKey == 101) minKey = -1
        return minKey
    }


    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        keyInit(keymap)
        val answer = IntArray(targets.size)

        for (i in targets.indices) {
            var count = 0
            for (j in 0 until targets[i].length) {
                if (mapCompare(keyList, targets[i][j]) == -1) {
                    count = -1
                    break
                } else {
                    count += mapCompare(keyList, targets[i][j])
                }
            }
            answer[i] = count
        }
        println("${answer.contentToString()}")
        return answer
    }
}

class VendingMachine2 {

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        return targets.map { str ->
            str.map { c ->
                keymap.map { str -> str.indexOf(c) + 1 }.filterNot { it < 1 }
                    .let { list ->
                        if (list.isEmpty()) -1
                        else list.minOf { it }
                    }
            }.let { list ->
                if (list.contains(-1)) -1
                else list.sum()
            }
        }.toIntArray()
    }
}


fun main() {
//    val result = VendingMachine().solution(arrayOf("ABACD", "BCEFD"), arrayOf("ABCD", "AABB"))
//    val result = VendingMachine().solution(arrayOf("AA"), arrayOf("B"))
//    val result = VendingMachine().solution(arrayOf("AGZ", "BSSS"), arrayOf("ASA","BGZ"))

//    val result = VendingMachine2().solution(arrayOf("ABACD", "BCEFD"), arrayOf("ABCD", "AABB"))
//    val result = VendingMachine2().solution(arrayOf("AA"), arrayOf("B"))
//    val result = VendingMachine2().solution(arrayOf("AGZ", "BSSS"), arrayOf("ASA","BGZ"))

}