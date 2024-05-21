package com.example.codingtest.level1

class CardBundle {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cardIndex1 = 0
        var cardIndex2 = 0
        var answer = ""

        // solution1
//        for (str in goal) {
//            if (cards1[cardIndex1] == str) {
//                if (cardIndex1 != cards1.size - 1) cardIndex1++
//                answer = "Yes"
//            } else if (cards2[cardIndex2] == str) {
//                if (cardIndex2 != cards2.size - 1) cardIndex2++
//                answer = "Yes"
//            } else {
//                answer = "No"
//                break;
//            }
//        }
//        return answer

        // solution2
        run lable@ {
            goal.forEach {
                if (cardIndex1 < cards1.size && it == cards1[cardIndex1]) {
                    cardIndex1++
                    answer = "Yes"
                }
                else if (cardIndex2 < cards2.size && it == cards2[cardIndex2]) {
                    cardIndex2++
                    answer = "Yes"
                }
                else {
                    answer = "No"
                    return@lable
                }
            }
        }
        return answer
    }
}

fun main() {
    val result = CardBundle().solution(arrayOf("i", "drink", "water"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water"))
//    val result2 = CardBundle().solution(arrayOf("i", "water", "drink"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water"))
    println(result)
}