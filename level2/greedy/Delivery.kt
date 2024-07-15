package com.example.codingtest.level2.greedy

import java.util.Stack

// 택배 배달과 수거하기
class Delivery {
//    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
//        var answer = 0L
//        var d = 0
//        var p = 0
//
//        for (i in n-1 downTo 0) {
//            var cnt = 0
//
//            d -= deliveries[i]
//            p -= pickups[i]
//
//            while (d < 0 || p < 0) {
//                d += cap
//                p += cap
//                cnt += 1
//            }
//
//            answer += (i + 1) * 2 * cnt
//        }
//
//        return answer
//    }

    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        val ps = Stack<Pair<Int,Int>>()
        val ds = Stack<Pair<Int,Int>>()
        for(i in 0 until n){
            val d = deliveries[i] to i+1
            val p = pickups[i] to i+1
            if(d.first > 0){
                ds.push(d)
            }
            if(p.first > 0){
                ps.push(p)
            }
        }
        while(ps.isNotEmpty() || ds.isNotEmpty()){
            val dIdx = if(ds.isNotEmpty()) ds.peek().second else 0
            val pIdx = if(ps.isNotEmpty()) ps.peek().second else 0
            val idx = Math.max(dIdx,pIdx)
            answer+=idx*2
            var box = 0
            while(ds.isNotEmpty() && box < cap){
                val remain = cap-box
                if(ds.peek().first <= remain){
                    box+=ds.peek().first
                    ds.pop()
                } else {
                    val idx = ds.peek().second
                    val top = ds.pop().first-remain to idx
                    ds.push(top)
                    break
                }
            }
            box = 0
            while(ps.isNotEmpty() && box < cap){
                val remain = cap-box
                if(ps.peek().first <= remain){
                    box+=ps.peek().first
                    ps.pop()
                } else {
                    val idx = ps.peek().second
                    val top = ps.pop().first-remain to idx
                    ps.push(top)
                    break
                }
            }

        }
        return answer
    }
}

fun main() {
//    println(Delivery().solution(4, 5, intArrayOf(1, 0, 3, 1, 2), intArrayOf(0, 3, 0, 4, 0)))
//    println(Delivery().solution(2, 7, intArrayOf(1, 0, 2, 0, 1, 0, 2), intArrayOf(0, 2, 0, 1, 0, 2, 0)))
//    println(Delivery().solution(1, 5, intArrayOf(0, 0, 1, 0, 0), intArrayOf(0, 0, 0, 0, 0)))
//    println(Delivery().solution(2, 2, intArrayOf(0, 0), intArrayOf(0, 4)))
//    println(Delivery().solution(3, 2, intArrayOf(2, 4), intArrayOf(4,2 )))
    println(Delivery().solution(4, 4, intArrayOf(25, 24, 51, 0), intArrayOf(51, 0, 0, 49)))
}