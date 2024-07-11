package com.example.codingtest.level2

import java.util.*

// 마법의 엘리베이터
class Elevator {
    fun solution(storey: Int): Int {

        var remainStorey = storey
        var index = remainStorey.toString().length - 1
        var magicStone = 0


        while (remainStorey != 0) {
            var cur = remainStorey.toString()[index].toString().toInt()
            var digit = (remainStorey.toString().length - index) - 1

            if (cur < 5) {
                magicStone += cur
                remainStorey -= (cur * Math.pow(10.0, digit.toDouble())).toInt()
            } else if (cur > 5) {
                magicStone += (10 - cur)
                remainStorey += ((10.0 - cur) * Math.pow(10.0, digit.toDouble())).toInt()
            } else if (cur == 5 && index != 0){
                val next = remainStorey.toString()[index-1].toString().toInt()
                if (next < 5) {
                    magicStone += cur
                    remainStorey -= (cur * Math.pow(10.0, digit.toDouble())).toInt()
                } else {
                    magicStone += (10 - cur)
                    remainStorey +=((10.0 - cur) * Math.pow(10.0, digit.toDouble())).toInt()
                }
            } else {
                magicStone += cur
                remainStorey -= (cur * Math.pow(10.0, digit.toDouble())).toInt()
            }
            if(index != 0) {
                index--
            }
        }

        return magicStone
    }

}

fun main() {
    println(Elevator().solution(5555))
}