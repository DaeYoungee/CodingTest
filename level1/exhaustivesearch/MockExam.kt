package com.example.codingtest.level1.exhaustivesearch

// 모의 고사
class MockExam {
    fun solution(answers: IntArray): IntArray {
        val routine1 = intArrayOf(1,2,3,4,5)
        val routine2 = intArrayOf(2,1,2,3,2,4,2,5)
        val routine3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        val person1 = IntArray(answers.size) { routine1[it % routine1.size] }
        val person2 = IntArray(answers.size) { routine2[it % routine2.size] }
        val person3 = IntArray(answers.size) { routine3[it % routine3.size] }

        val count = hashMapOf( 1 to 0, 2 to 0, 3 to 0)

        for (i in answers.indices) {
            if (answers[i] == person1[i]) count[1] = count[1]!! + 1
            if (answers[i] == person2[i]) count[2] = count[2]!! + 1
            if (answers[i] == person3[i]) count[3] = count[3]!! + 1
        }

        val max = count.maxOf { it.value }
        return count.filter { it.value == max }.keys.toIntArray()

    }
}

fun main() {
    println(MockExam().solution(intArrayOf(1,2,3,4,5)).contentToString())
    println(MockExam().solution(intArrayOf(1,3,2,4,2)).contentToString())
}