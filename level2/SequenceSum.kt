package com.example.codingtest.level2

// 연속된 부분 수열의 합
class SequenceSum {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var lPointer = 0
        var rPointer = 0
        var answer = intArrayOf(0,Int.MAX_VALUE)
        var sum = sequence[rPointer]

        while (lPointer < sequence.size) {
//                println("rPointer: $rPointer, lPointer: $lPointer, sum: $sum")
            if (sum < k) {
                if (rPointer == sequence.size - 1) break
                sum += sequence[++rPointer]
            } else if (sum == k) {
//                println("rPointer: $rPointer, lPointer: $lPointer, sum: $sum")
                if (answer[1] - answer[0] > rPointer - lPointer) {
                    answer[0] = lPointer
                    answer[1] = rPointer
                }
                sum -= sequence[lPointer++]
            } else {
                sum -= sequence[lPointer++]
            }
        }


        return answer
    }

//    fun solution(sequence: IntArray, k: Int): IntArray {
//        //two pointer
//        var l = 0
//        var r = 0
//        var sum = sequence[r]
//        var answer = intArrayOf(0,Int.MAX_VALUE)
//        //항상 K와 가깝게
//        //sum이 K보다 작다면 R포인터 늘리고, sum이 k크거나 같으면 L포인터 늘리고
//        while(l < sequence.size){
//            println("rPointer: $r, lPointer: $l,")
//            if(sum < k){
//                if(r == sequence.size-1) break
//                sum += sequence[++r]
//            }else{
//                if(sum == k){
//                    if(answer[1]-answer[0] > r-l){
//                        answer[0] = l
//                        answer[1] = r
//                    }
//                }
//                sum -= sequence[l++]
//            }
//        }
//        return answer
//    }
}

fun main() {
    println(SequenceSum().solution(intArrayOf(1, 2, 3, 4, 5), 7).contentToString())
    println(SequenceSum().solution(intArrayOf(1, 1, 1, 2, 3, 4, 5), 5).contentToString())
    println(SequenceSum().solution(intArrayOf(2, 2, 2, 2, 2), 6).contentToString())


}