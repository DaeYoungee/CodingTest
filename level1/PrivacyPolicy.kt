package com.example.codingtest.level1

// 개인정보 유효기간
class PrivacyPolicy {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val term = hashMapOf<String, Int>()
        var answer = mutableListOf<Int>()

        terms.forEach { str ->
            term[str.split(" ")[0]] = str.split(" ")[1].toInt()
        }
        privacies.forEachIndexed { index, str ->
            val list = str.split(" ")

            var year = list[0].split(".")[0].toInt()
            var month = monthDayToInt(list[0].split(".")[1])
            val day = monthDayToInt(list[0].split(".")[2]) - 1

            /*
            val quotient = month / 12, 해서 quotient의 크기 만큼 year에 더해줌
            val month = month % 12 로 month 계산

            but 문제 발생

            Counterexample)
            year = 2009, month = 11, 보험 A가 13개월이라고 가정
            mapping된 data는 year = 2010, month = 12, 이 나와야 정상이다.
            그러나 위의 식에 대입을 했을 때  year = 2011, month = 0, 이 나온다.

            따라서 아래와 같은 로직으로 해결

             */
            val quotient =
                if ((month + term[list[1]]!!) % 12 == 0) {
                    (month + term[list[1]]!!) / 12 - 1
                } else {
                    ((month + term[list[1]]!!) / 12)
                }
            month =
                if ((month + term[list[1]]!!) % 12 == 0) 12
                else (month + term[list[1]]!!) % 12
            year += quotient

            println("$year.$month.$day")

            if (today.split(".")[0].toInt() == year) {
                if (monthDayToInt(today.split(".")[1]) == month) {
                    if (monthDayToInt(today.split(".")[2]) > day) {
                        answer.add(index + 1)
                    }
                } else if (monthDayToInt(today.split(".")[1]) > month) {
                    answer.add(index + 1)
                }
            } else if (today.split(".")[0].toInt() > year) {
                answer.add(index + 1)
            }
        }
        return answer.toIntArray()
    }

    private fun monthDayToInt(month: String) =
        if (month[0] == '0') {
            month[1].toString().toInt()
        } else {
            month.toInt()
        }

}


fun main() {
//    val result1 = PrivacyPolicy().solution(
//        "2022.05.19",
//        arrayOf("A 6", "B 12", "C 3"),
//        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
//    )
//    val result2 = PrivacyPolicy().solution(
//        "2020.01.01",
//        arrayOf("Z 3", "D 5"),
//        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
//    )
    val result3 = PrivacyPolicy().solution(
        "2009.12.31",
        arrayOf("A 13"),
        arrayOf("2008.11.03 A")
    )
    println(result3.contentToString())
}