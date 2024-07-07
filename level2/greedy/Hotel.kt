package com.example.codingtest.level2.greedy

// 호텔 대실
class Hotel {
    fun solution(book_time: Array<Array<String>>): Int {
        var room = mutableListOf<Pair<Int, Int>>()

        val bookTime = book_time.map { array -> array.map { hourToMinute(it) } }.sortedBy { it[0] }
        println(bookTime)
        bookTime.forEach { book ->
            val start = book[0]
            val end = book[1]
            // room이 하나도 예약되어 있지 않을 때, 초기화
            if (room.isEmpty()) {
                room.add(start to end)
            } else {
                // room에 들어있는 시간과 예약시간 확인
                if (room.count { start < it.second + 10 } == room.count()) {
                    room.add(start to end)
                } else {
                    for ((index, r) in room.withIndex()) {
                        if (start >= r.second + 10) {
                            room[index] = start to end
                            break
                        }
                    }
                }
            }
        }
        return room.count()
    }

    fun hourToMinute(time: String): Int {
        val (h, m) = time.split(":").map { it.toInt() }
        return h * 60 + m
    }
}


fun main() {
//    Hotel().solution(
//        arrayOf(
//            arrayOf("15:00", "17:00"),
//            arrayOf("16:40", "18:20"),
//            arrayOf("14:20", "15:20"),
//            arrayOf("14:10", "19:20"),
//            arrayOf("18:20", "21:20")
//        )
//    )

    println(Hotel().solution(
        arrayOf(
            arrayOf("09:10", "10:11"),
            arrayOf("10:20", "12:20")
        )
    ))
}