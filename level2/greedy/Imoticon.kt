package com.example.codingtest.level2.greedy

import java.util.ArrayList

class Imoticon {
    val discount = intArrayOf(40, 30, 20, 10)
    var emoticonDiscount = ArrayList<Int>()
    var results = mutableSetOf<Pair<Int, Int>>()

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        recursion(0, users, emoticons)

        val test = results.sortedWith(compareBy<Pair<Int, Int>>({it.first}, {it.second}).reversed()).first().toList().toIntArray()
        println(test.contentToString())
        return test
    }

    fun recursion(depth: Int, users: Array<IntArray>, emoticons: IntArray) {
        if (depth == emoticons.size) {
            getEmoticonPrice(emoticonDiscount, users, emoticons)
            return
        }

        for (i in 0..3) {
            emoticonDiscount.add(discount[i])
            recursion(depth + 1, users, emoticons)
            emoticonDiscount.removeLast()
        }
    }

    fun getEmoticonPrice(emoticonDiscount: ArrayList<Int>, users: Array<IntArray>, emoticons: IntArray) {
        var p = mutableListOf<Int>()
        var join = 0
        var totalPrice = 0

        for (i in users.indices) {
            var sum = 0.0
            var (per, price) = users[i]
            for (j in emoticonDiscount.indices) {
                if (per <= emoticonDiscount[j]) {
                    sum += (emoticons[j]*(100.0 - emoticonDiscount[j])/100)
                }
            }

            if (price <= sum) {
                join++
            } else {
                totalPrice += sum.toInt()
            }
        }

        results.add(join to totalPrice)
    }
}

fun main() {
    Imoticon().solution(arrayOf(intArrayOf(40, 10000), intArrayOf(25, 10000)), intArrayOf(7000, 9000))
}