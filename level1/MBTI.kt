package com.example.codingtest.level1

import kotlin.text.StringBuilder

class MBTI {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val score = hashMapOf<Char, Int>(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0
        )
        val result = StringBuilder()
        survey.forEachIndexed { index, s ->
            when (choices[index]) {
                1 -> score[s[0]] = score[s[0]]!! + 3
                2 -> score[s[0]] = score[s[0]]!! + 2
                3 -> score[s[0]] = score[s[0]]!! + 1
                4 -> 0
                5 -> score[s[1]] = score[s[1]]!! + 1
                6 -> score[s[1]] = score[s[1]]!! + 2
                7 -> score[s[1]] = score[s[1]]!! + 3
            }
        }
        if (score['R']!! >= score['T']!!) {
            result.append('R')
        } else result.append('T')
        if (score['C']!! >= score['F']!!) {
            result.append('C')
        } else result.append('F')
        if (score['J']!! >= score['M']!!) {
            result.append('J')
        } else result.append('M')
        if (score['A']!! >= score['N']!!) {
            result.append('A')
        } else result.append('N')
        return result.toString()
    }

}

fun main() {
    println(MBTI().solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5,3,2,7,5)))
    println(MBTI().solution(arrayOf("TR", "RT", "TR"), intArrayOf(7,1,3)))
    
}

