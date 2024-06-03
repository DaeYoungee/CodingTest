package com.example.codingtest.level1

// 신고 결과 받기
class ReportResult {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportPerson = hashMapOf<String, List<String>>()
        val reportedPerson = hashMapOf<String, List<String>>()
        val reportCount = hashMapOf<String, Int>()
        val notificationCount = IntArray(id_list.size)

        id_list.forEach {
            reportPerson[it] = emptyList()
            reportedPerson[it] = emptyList()
            reportCount[it] = 0
        }


        report.map { str -> str.split(" ") }.forEach {
            if (!reportPerson[it[0]]?.contains(it[1])!!){
                reportPerson[it[0]] = reportPerson[it[0]]!! + it[1]
                reportedPerson[it[1]] = reportedPerson[it[1]]!! + it[0]
            }
        }
        println("reportPerson: $reportPerson")
        println("reportedPerson: $reportedPerson")



        reportPerson.forEach { name, list ->
            var index = 0
            list.forEach { str ->
                id_list.forEach {
                    if (str == it) {
                        reportCount[str] = reportCount[str]!! + 1
                    }
                }
            }
        }
        println("reportCount: $reportCount")

        reportCount.filter { it.value >= k }.map{it.key}.forEach { str1 ->
            reportedPerson[str1]?.forEach { str2 ->
                id_list.forEachIndexed { index, s ->
                    if (s == str2) {
                        notificationCount[index] += 1
                    }
                }
            }
        }

        println("notificationCount: ${notificationCount.contentToString()}")

        return notificationCount
    }
}

fun main() {
    println(ReportResult().solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2))
    println(ReportResult().solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3))
}