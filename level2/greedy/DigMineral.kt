package com.example.codingtest.level2.greedy

// 광물 캐기
class DigMineral {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        println("minerals :${minerals.contentToString()}")
        println("picks :${picks.contentToString()}")

        val arraySize = if (minerals.size % 5 == 0) {
            minerals.size / 5
        } else {
            minerals.size / 5 + 1
        }

        val arraySize2 = if (picks.sum() < arraySize) {
            picks.sum()
        } else {
            arraySize
        }

        val list = Array(arraySize2) { index ->
            if (index == minerals.size / 5) {
                minerals.sliceArray(index * 5 until index * 5 + minerals.size % 5).groupingBy { it }
                    .eachCount()
            } else {
                minerals.sliceArray(index * 5 until (index + 1) * 5).groupingBy { it }.eachCount()
            }
        }
            .sortedWith(compareBy({ it["diamond"] }, { it["iron"] }, { it["stone"] }))
            .reversed()
            .map {
                if (picks[0] > 0) {
                    picks[0]--
                    it.getOrDefault("diamond", 0) + it.getOrDefault(
                        "iron",
                        0
                    ) + it.getOrDefault("stone", 0)
                } else if (picks[1] > 0) {
                    picks[1]--
                    it.getOrDefault("diamond", 0) * 5 + it.getOrDefault(
                        "iron",
                        0
                    ) + it.getOrDefault("stone", 0)
                } else if (picks[2] > 0) {
                    picks[2]--
                    it.getOrDefault("diamond", 0) * 25 + it.getOrDefault(
                        "iron",
                        0
                    ) * 5 + it.getOrDefault("stone", 0)
                } else {
                    0
                }
            }

        println("list: $list")

        return list.sum()
    }
}

fun main() {
//    println(
//        DigMineral().solution(
//            intArrayOf(1, 3, 2),
//            arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
//        )
//    )
//    println(
//        DigMineral().solution(
//            intArrayOf(0, 1, 1),
//            arrayOf(
//                "diamond",
//                "diamond",
//                "diamond",
//                "diamond",
//                "diamond",
//                "iron",
//                "iron",
//                "iron",
//                "iron",
//                "iron",
//                "diamond"
//            )
//        )
//    )
    // test case 8 반례
    // 기대값: 10
    println(
        DigMineral().solution(
            intArrayOf(1, 0, 1),
            arrayOf(
                "stone", "stone", "stone", "stone", "stone", "iron", "iron", "iron", "iron", "iron", "diamond", "diamond"
            )
        )
    )
}