package com.example.codingtest.level1

// 로또의 최고 순위와 최저 순위
class LottoRank {
    //    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
//        var unRecognizeNum = 0
//        var answerCount = 0
//        val answer = IntArray(2)
//        unRecognizeNum = lottos.count { it == 0 }
//        lottos.filter { it != 0 }.forEach {
//            if (win_nums.contains(it)) answerCount++
//        }
//        when (answerCount + unRecognizeNum) {
//            6 -> answer[0] = 1
//            5 -> answer[0] = 2
//            4 -> answer[0] = 3
//            3 -> answer[0] = 4
//            2 -> answer[0] = 5
//            else -> answer[0] = 6
//        }
//        when (answerCount) {
//            6 -> answer[1] = 1
//            5 -> answer[1] = 2
//            4 -> answer[1] = 3
//            3 -> answer[1] = 4
//            2 -> answer[1] = 5
//            else -> answer[1] = 6
//        }
//        println(answer.contentToString())
//        return answer
//    }
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {

        val unRecognizeNum = lottos.count { it == 0 }
        val answerCount = lottos.count { win_nums.contains(it) }

        val max = answerCount + unRecognizeNum

        return intArrayOf(
            if (max < 2) 6 else 7 - max,
            if (answerCount < 2) 6 else 7 - answerCount
        )
    }
}

fun main() {
    println(LottoRank().solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19)).contentToString())
}