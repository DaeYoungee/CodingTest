package com.example.codingtest.level2

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

// 두 원 사이의 정수 쌍
class BetweenTwoCircle {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        // 풀이
        // 피타고라스 정리를 이용해서 두 원 사이의 y축 좌표의 차이(높이)를 구한다. -> 두 원 사이에 존재하는 원의 개수 이 때 그 개수를 a라고 가정하자
        // a를 구할 때 주의할 점은 r1(반지름이 더 작은 원)의 정수 쌍이 원 위에 놓여져 있는가를 확인 해야 한다. ex) r=5인 경우 x=0 뿐만 아니라 x=4 or x=3에도 정수 쌍이 원 위에 놓여져 있다.
        // 단 r2(반지름이 더 큰 원)의 정수 쌍이 원 위에 놓여지는 경우에 대해서는 몰라도 된다.
        // 예를 들어 r1 = 5, r2 = 10인 경우
        // x=2값일 때 두 원 사이에 정수 쌍의 개수는 5개이다. y1 = 4, y2 = 9이다. y2 - y1 = 5 이기 떄문이다.
        // 그러나 x=4값인 경우 y1 = 3, y2 = 9. 즉 y2-y1 = 6이지만, 두 원 사이에 정수 쌍의 개수는 7개이다.
        // 왜냐하면 x=4인 경우 r1인 원위에 정수 쌍이 존재하기 때문이다.

        // x좌표가 0인 경우 두 원 사이의 정수 쌍의 개수를 b라고 하자.
        // 1사분면의 개수만 구했기 때문에 a와 b에 적당히 4를 곱해서 더한 값이 결과 값이다.


//        for(x in 1..r2) {
//            val y2 = sqrt(r2.toDouble().pow(2.0) - x.toDouble().pow(2.0)).toLong()
//            val smallY = sqrt(r1.toDouble().pow(2.0) - x.toDouble().pow(2.0))
//            val y1 = smallY.toLong()
//            answer += (y2 - y1)
//
//            if(smallY % 1 == 0.0 && y1 > 0) {   // 정수
//                answer++
//            }
//            println("x: $x, y2 : ${y2.toLong()}, y1 : ${y1.toLong()}, answer : $answer")
//
//        }
//
//        return answer * 4 + (r2 - r1 + 1) * 4

        for (x in 0..r2) {
            val y2 = sqrt(r2.toDouble().pow(2) - x.toDouble().pow(2))
            val y1 = sqrt(r1.toDouble().pow(2) - x.toDouble().pow(2))
            if (y1 % 1 == 0.0 &&  y1 > 0) {
                answer += 1
                println("들어감? y2 : $y2, y1 : $y1")
            }
            answer += (y2.toLong() - y1.toLong())
            println("x: $x, y2 : ${y2.toLong()}, y1 : ${y1.toLong()}, answer : $answer")

        }
        return answer*4


//        for(r in 1 .. r2){
//            val upper = floor(sqrt(r2*r2.toDouble() - r*r.toDouble())).toLong()
//            val lower = ceil(sqrt(r1*r1.toDouble() - r*r.toDouble())).toLong()
//            answer += upper - lower + 1
//        }
//
//        return 4 * answer
    }


}


fun main() {
    println(BetweenTwoCircle().solution(2, 3))
//    println(BetweenTwoCircle().solution(1, 4))
//    println(BetweenTwoCircle().solution(2, 4))
//    println(BetweenTwoCircle().solution(5, 8))
//    println(BetweenTwoCircle().solution(5, 10))
//    println(BetweenTwoCircle().solution(2, 5))


//    println(BetweenTwoCircle().solution(999999, 1000000))


}