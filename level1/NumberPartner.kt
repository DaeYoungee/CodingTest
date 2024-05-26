package com.example.codingtest.level1

class NumberPartner {
    fun solution(X: String, Y: String): String {
        val countsX = X.groupingBy { it }.eachCount()
        val number = Array(10) { it.toString() }
        var partner = mutableListOf<Int>()
        for (i in number.indices) {
            if (X.contains(number[i]) && Y.contains(number[i])) {
               if (X.count { it.toString() == number[i] } > Y.count { it.toString() == number[i] } ) {
                    repeat(Y.count { it.toString() == number[i] }) {
                        partner.add(number[i].toInt())
                    }
                } else {
                    repeat(X.count { it.toString() == number[i] }) {
                        partner.add(number[i].toInt())
                    }
                }
            }
        }

        if (partner.maxOrNull() == 0) {
            partner = partner.distinct().toMutableList()
            println("partner: $partner")
        }
        else if (partner.isEmpty()) partner.add(-1)
        return partner.sortedDescending().fold("") { sum, num ->
            sum + num
        }
    }
}


fun main() {
    println(NumberPartner().solution("100", "2345"))
//    println(NumberPartner().solution("100", "203045"))
//    println(NumberPartner().solution("100", "123450"))
//    println(NumberPartner().solution("12321", "42531"))
//    println(NumberPartner().solution("5525", "1255"))
    println(NumberPartner().solution("100", "100"))
    println(NumberPartner().solution("10000", "20000"))

}