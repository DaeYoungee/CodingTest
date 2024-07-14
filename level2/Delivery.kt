package com.example.codingtest.level2

import java.util.Stack

// 택배 배달과 수거하기
class Delivery {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer = 0L


        var d = 0
        var p = 0

        for (i in n-1 downTo 0) {
            var cnt = 0

            d -= deliveries[i]
            p -= pickups[i]

            while (d < 0 || p < 0) {
                d += cap
                p += cap
                cnt += 1
            }

            answer += (i + 1) * 2 * cnt
        }

        return answer


//        var answer: Long = 0
//
//        val d = Stack<Pair<Int, Int>>()
//        val p = Stack<Pair<Int, Int>>()
//
//        deliveries.forEachIndexed { index, i ->
//            if (i != 0) {
//                d.push(index to i)
//            }
//        }
//        pickups.forEachIndexed { index, i ->
//            if (i != 0) {
//                p.push(index to i)
//            }
//        }
//
//        while (d.isNotEmpty() || p.isNotEmpty()) {
//
//            var deliveryCount = if (d.isEmpty()) {
//                0
//            } else {
//                var index = d.lastIndex
//                val sum = d.sumOf { it.second }
//                if (sum > cap) {
//                    cap
//                } else {
//                    sum
//                }
//            }
//            if (d.isEmpty() && p.isNotEmpty()) {
//                answer += (p.peek().first + 1) * 2
//            } else if (d.isNotEmpty() && p.isEmpty()) {
//                answer += (d.peek().first + 1) * 2
//            } else if (d.isNotEmpty() && p.isNotEmpty()) {
//                answer += (p.peek().first + 1).coerceAtLeast(d.peek().first + 1) * 2
//            }
//
//
//
//            while (deliveryCount > 0) {
//                if (d.isEmpty()) { break }
//
//                var dHome = d.pop()
//                if (deliveryCount - dHome.second < 0) {
//                    d.push(dHome.first to dHome.second - deliveryCount)
//                    deliveryCount = 0
//                } else {
//                    deliveryCount -= dHome.second
//                }
//            }
//
//
//
//            while (deliveryCount < cap) {
//                if (p.isEmpty()) { break }
//                var pHome = p.pop()
//                if (pHome.second + deliveryCount > cap) {
//                    p.push(pHome.first to pHome.second - (cap - deliveryCount))
//                    deliveryCount = cap
//                    continue
//                } else {
//                    deliveryCount += pHome.second
//                }
//            }
//        }
//
//        return answer
    }
}


// "택배"의 수량이 cap의 개수와 동일하면 택배 배달하고 돌아오면서 "빈 박스" 수거하기
// 0 < "택배" < cap 이면 앞에 있는 인덱스 찾아야 함

// stack에 택배를 배달해야 하는 집만 넣어서 탐색해보자. 자연스럽게 뒤에있는 집부터 탑색하게 된다.
// stack에 넣는 값은 집의 번호(deliveries의 인덱스)


fun main() {
//    println(Delivery().solution(4, 5, intArrayOf(1, 0, 3, 1, 2), intArrayOf(0, 3, 0, 4, 0)))
//    println(Delivery().solution(2, 7, intArrayOf(1, 0, 2, 0, 1, 0, 2), intArrayOf(0, 2, 0, 1, 0, 2, 0)))
//    println(Delivery().solution(1, 5, intArrayOf(0, 0, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0)))
//    println(Delivery().solution(2, 2, intArrayOf(0, 0), intArrayOf(0, 4)))
//    println(Delivery().solution(3, 2, intArrayOf(2, 4), intArrayOf(4,2 )))
    println(Delivery().solution(4, 4, intArrayOf(25, 24, 51, 0), intArrayOf(51, 0, 0, 49)))
}