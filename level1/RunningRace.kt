package com.example.codingtest.level1

fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    var answer = Array<String>(players.size) { "" }
    val rank = hashMapOf<Int, String>()
    val player = hashMapOf<String, Int>()

    for (i in players.indices) {
        rank[i] = players[i]
        player[players[i]] = i
    }

    callings.forEach {
        val winner = it
        val winnerRank = player[it]!! - 1 // 호명한 사람의 변경된 순위

        val looser = rank[winnerRank]!!  // 호명한 사람과 바뀌는 사람의 이름
        val looserRank = winnerRank + 1 // 호명한 사람과 바뀌는 사람의 변경된 순위

        rank[winnerRank] = winner
        rank[looserRank] = looser
        player[winner] = winnerRank
        player[looser] = looserRank
        println(rank.values)
    }
    rank.forEach {
        answer[it.key] = it.value
    }

    return answer
}

fun main() {
    val result = solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    )
}

// List 내에서 특정 원소의 인덱스 값을 찾는 일보다 HashMap을 통해 원소의 인덱스를 찾는 것이 훨씬 빠르다.