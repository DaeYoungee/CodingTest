package com.example.codingtest.level1

// 가장 많이 받은 선물
class MostRecievedPresent {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
//        val recieved = hashMapOf<String, Int>()
//        val list = gifts.map { it.split(" ")[0] to it.split(" ")[1] }
//        val givedList = list.groupBy({ it.first }, { it.second })
//        val recievedList = list.groupBy({ it.second }, { it.first })
//        val presentIndicator = friends.associateWith {
//            (givedList[it]?.count() ?: 0) - (recievedList[it]?.count() ?: 0)
//        }
//
//        givedList.forEach { (key, value) ->
//            for (i in friends) {
//                val count1 = value.count { it == i }
//                val count2 = givedList[i]?.count { it == key } ?: 0
//                if (count1 > count2) {
//                    recieved[key] = (recieved[key]?: 0) + 1
//                } else if (count1 == count2) {
//                    if (presentIndicator[key]!! > presentIndicator[i]!!) {
//                        recieved[key] = (recieved[key]?: 0) + 1
//                    }
//                }
//            }
//        }
//
//        println(givedList)
//        println(recievedList)
//        println(presentIndicator)
//
//        println(recieved)
//
//        return if (recieved.isEmpty()) 0 else recieved.values.maxOf { it }

        val giftIndex = IntArray(friends.size)
        val giftCounts = Array(friends.size) { IntArray(friends.size) }
        val indexByFriend = friends
            .withIndex()
            .asSequence()
            .associate { it.value to it.index }

        for (gift in gifts) {
            val (give, given) = gift.split(" ")
            val i = indexByFriend[give]!!
            val j = indexByFriend[given]!!

            giftCounts[i][j]++

            giftIndex[i]++
            giftIndex[j]--
        }

        var answer = 0
        for (i in friends.indices) {
            val count = friends.indices.sumOf { j ->
                when {
                    giftCounts[i][j] > giftCounts[j][i] -> 1
                    giftCounts[i][j] < giftCounts[j][i] -> 0
                    giftIndex[i] > giftIndex[j] -> 1
                    giftIndex[i] < giftIndex[j] -> 0
                    else -> 0
                } as Int
            }

            if (answer < count) {
                answer = count
            }
        }

        return answer
    }
}

fun main() {
    println(
        MostRecievedPresent().solution(
            arrayOf("muzi", "ryan", "frodo", "neo"),
            arrayOf(
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"
            )
        )
    )
    println(
        MostRecievedPresent().solution(
            arrayOf("joy", "brad", "alessandro", "conan", "david"),
            arrayOf(
                "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"
            )
        )
    )

    println(
        MostRecievedPresent().solution(
            arrayOf("a", "b", "c"),
            arrayOf(
                "a b", "b a", "c a", "a c", "a c", "c a"
            )
        )
    )


}