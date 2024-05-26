package com.example.codingtest.level1

class NumberPartner {
    fun solution(X: String, Y: String): String {
        val mapX = X.groupingBy { it }.eachCount()
        val mapY = Y.groupingBy { it }.eachCount()
        var partner = ""
        var zero = true

        for (dight in '9' downTo '1') {
            val count = minOf(mapX.getOrDefault(dight, 0), mapY.getOrDefault(dight, 0))
            if (count > 0) {
                zero = false
                partner += dight.toString().repeat(count)
            }
        }
        val zeroCount = minOf(mapX.getOrDefault('0', 0), mapY.getOrDefault('0', 0))
        if (zeroCount > 0 && !zero) {
            partner += '0'.toString().repeat(zeroCount)
        } else if (zeroCount > 0 && zero) {
            partner += '0'
        }
        return partner.toString().ifEmpty { "-1" }
    }
}


fun main() {
    println(NumberPartner().solution("100", "2345"))
    println(NumberPartner().solution("100", "203045"))
    println(NumberPartner().solution("100", "123450"))
    println(NumberPartner().solution("12321", "42531"))
    println(NumberPartner().solution("5525", "1255"))
    println(NumberPartner().solution("100", "100"))
    println(NumberPartner().solution("10000", "20000"))

}