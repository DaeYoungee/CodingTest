package com.example.codingtest.level1

// 가장 많이 받은 선물
class MostRecievedPresent {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val recieved = hashMapOf<String, Int>()  // 다음 달에 선물 받을 개수를 담은 map
        val list = gifts.map { it.split(" ")[0] to it.split(" ")[1] }
        val givedList = list.groupBy({ it.first }, { it.second })     // 선울을 준 사람: [받은 사람1, 받은 사람2] 와 같은 map 형태
        val recievedList = list.groupBy({ it.second }, { it.first })  // 선물을 받은 사람: [선물을 준 사람1, 선물을 준 사람2] 와 같은 map 형태
        val presentIndicator = friends.associateWith {
            (givedList[it]?.count() ?: 0) - (recievedList[it]?.count() ?: 0)
        }

        givedList.forEach { (key, value) ->
            for (i in friends) {
                val count1 = value.count { it == i }
                val count2 = givedList[i]?.count { it == key } ?: 0
                if (count1 > count2) {
                    recieved[key] = (recieved[key]?: 0) + 1
                } else if (count1 == count2) {
                    if (presentIndicator[key]!! > presentIndicator[i]!!) {
                        recieved[key] = (recieved[key]?: 0) + 1
                    }
                }
            }
        }

//        println(givedList)
//        println(recievedList)
//        println(presentIndicator)
//
//        println(recieved)

        return if (recieved.isEmpty()) 0 else recieved.values.maxOf { it }

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