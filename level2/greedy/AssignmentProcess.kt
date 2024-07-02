package com.example.codingtest.level2.greedy

import java.util.Stack

// 과제 진행하기
class AssignmentProcess {
    fun solution(plans: Array<Array<String>>): Array<String> {

        var completeList = mutableListOf<String>()
        var waitStack = Stack<Plan>()

        var list =
            plans.map { Plan(it[0], minuteMapper(it[1]), it[2].toInt()) }.sortedBy { it.start }
                .toMutableList()
        var runningPlan: Plan? = null
        var currentTime = 0

        while (completeList.count() < plans.count()) {
            println("running: $runningPlan, \nlist: $list, \ncompleteList: $completeList, \nwaitStack: $waitStack, \ncurrent: $currentTime\n\n")

            // running 초기값 설정
            if (runningPlan == null) {
                runningPlan = list[0]
                list.removeAt(0)
                currentTime = runningPlan.start
                continue
            }

            if (list.isNotEmpty()) {

                // 실행시간 이 후 여유 시간이 존재
                if (currentTime + runningPlan.playtime < list[0].start) {
                    currentTime += runningPlan.playtime
                    completeList.add(runningPlan.name)
                    if (waitStack.isNotEmpty()) {
                        runningPlan = waitStack.pop()
                    } else {
                        runningPlan = list[0]
                        list.removeAt(0)
                        // 실행하고 list[0]를 running으로 올리려고 했으나 시작시간(start)가 아직 되지 않음을 의미
                        if (currentTime != runningPlan.start) currentTime = runningPlan.start
                    }
                } else if (currentTime + runningPlan.playtime == list[0].start) { // 실행시간 이 후 여유 시간 없이 list의 0번 째 원소 바로 실행
                    currentTime += runningPlan.playtime
                    completeList.add(runningPlan.name)
                    runningPlan = list[0]
                    list.removeAt(0)
                } else {  // 실행시간 이 후 여유 시간 부족
                    val waitPlan = Plan(
                        runningPlan.name,
                        runningPlan.start,
                        runningPlan.playtime - (list[0].start - currentTime),
                    )
                    currentTime += (list[0].start - currentTime)
                    waitStack.push(waitPlan)
                    runningPlan = list[0]
                    list.removeAt(0)
                }
            } else {
                completeList.add(runningPlan.name)
                repeat(waitStack.count()) {
                    completeList.add(waitStack.pop()!!.name)
                }
                break
            }
        }


        println("completeList: $completeList")
        return completeList.toTypedArray()
    }

    private fun minuteMapper(time: String): Int {
        val (hour, minute) = time.split(":").map { it.toInt() }
        return hour * 60 + minute
    }
}


data class Plan(
    val name: String,
    val start: Int,
    val playtime: Int,
)

fun main() {
//    println(
//        AssignmentProcess().solution(
//            arrayOf(
//                arrayOf("korean", "11:40", "30"),
//                arrayOf("english", "12:10", "20"),
//                arrayOf("math", "12:30", "40")
//            )
//        ).contentToString()
//    )
//    println(
//        AssignmentProcess().solution(
//            arrayOf(
//                arrayOf("science", "12:40", "50"),
//                arrayOf("music", "12:20", "40"),
//                arrayOf("history", "14:00", "30"),
//                arrayOf("computer", "12:30", "100")
//            )
//        )
//    )

//    println(
//        AssignmentProcess().solution(
//            arrayOf(
//                arrayOf("1", "00:00", "30"),
//                arrayOf("2", "00:10", "40"),
//                arrayOf("3", "00:20", "10"),
//                arrayOf("4", "00:25", "10"),
//                arrayOf("5", "01:10", "10")
//            )
//        )
//    )

//    println(
//        AssignmentProcess().solution(
//            arrayOf(
//                arrayOf("UmmLang", "11:00", "10"),
//                arrayOf("MSA", "11:08", "1"),
//                arrayOf("Redis", "11:10", "1"),
//                arrayOf("Kafka", "11:12", "1")
//            )
//        ).contentToString()
//    )

    println(
        AssignmentProcess().solution(
            arrayOf(
                arrayOf("korean", "11:40", "20"),
                arrayOf("english", "12:10", "30"),
                arrayOf("math", "12:30", "40")
            )
        ).contentToString()
    )


}