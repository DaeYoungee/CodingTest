package com.example.codingtest.level2.distance

// 점 찍기
// https://school.programmers.co.kr/learn/courses/30/lessons/140107
class Dot {

    /* 2중 for문 실패
    fun solution(k: Int, d: Int): Long {
        var count = 0L

        for (x in 0..d step k) {
            for (y in 0..d step k) {
                if (x.toLong()*x + y.toLong()*y > d.toLong()*d) break
                else count++
            }
        }
        println(count)
        return count
    }
    */



    // for 1개 풀이
    // 해설:
    // 1. x = i*k, y = j*k 이며 i,j는 실제 x와 y의 좌표
    // 2. 피타고라스의 정리 x^2 + y^2 = d^2 식을 이용
    // 3. sqrt(d^2 - x^2) = y 로 변경
    // 4. j = y/k
    // 5. count += (j+1)
    /*
    예를 들어 x = 0, d = 17, k = 4 이면 y는 17이 나온다.
    이 때 실제 y의 좌표는 17/k인 4이다. 0~4까지 모든 y좌표가 가능하는 의미이다.
    따라서 y+1 를 count에 더해준다.
    */




    fun solution(k: Int, d: Int): Long {
        var count = 0L
        for (x in 0..d step k) {
            val y = Math.sqrt(d.toDouble()*d - x.toDouble()*x).toLong() / k
            count += (y+1)
        }
        return count
    }
}

fun main() {
    val dot = Dot()
    dot.solution(4, 17)

}