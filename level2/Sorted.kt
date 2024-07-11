package com.example.codingtest.level2

fun main() {


    val arr1 = arrayOf(
        Person("J", 25, 170),
        Person("K", 20, 160),
        Person("L", 22, 180),
        Person("M", 21, 174),
        Person("A", 21, 168)
    )
    val arr2 = arrayOf(
        Person("J", 25, 183),
        Person("K", 20, 182),
        Person("L", 22, 177),
        Person("M", 21, 176)
    )

    println("arr1: ${arr1.contentToString()}")
    // Person(name=J, age=25), Person(name=K, age=20), Person(name=L, age=22), Person(name=M, age=21)

    val arr3 = arr1.sortedWith(compareBy { it.age })
    println("arr3: $arr3")
    // Person(name=K, age=20), Person(name=M, age=21), Person(name=A, age=21), Person(name=L, age=22), Person(name=J, age=25)

//    val arr4 = arr1.sortedWith(compareBy({it.age}, {it.name}))
    val arr4 = arr1.sortedWith(compareBy<Person>{it.age}.thenBy { it.name })
    println("arr4: $arr4")
    // Person(name=K, age=20), Person(name=A, age=21), Person(name=M, age=21), Person(name=L, age=22), Person(name=J, age=25)

    val arr5 = arr1.sortedWith(compareBy<Person>{it.age}.thenByDescending { it.height })
    val arr6 = arr1.sortedWith(compareBy({it.age}, { -it.height }))
    println("arr5: $arr5")
    // Person(name=K, age=20, height=160), Person(name=M, age=21, height=174), Person(name=A, age=21, height=168), Person(name=L, age=22, height=180), Person(name=J, age=25, height=170)
    println("arr6: $arr6")
    // Person(name=K, age=20, height=160), Person(name=M, age=21, height=174), Person(name=A, age=21, height=168), Person(name=L, age=22, height=180), Person(name=J, age=25, height=170)

    val arr7 = arr1.sortedWith(compareBy<Person>{it.age}.reversed().thenBy { it.height })
    println("arr7: $arr7")


//    val arr5 = arr4.sortedBy { it.age }
//
//    println("arr4: ${arr4.contentToString()}") // Person(name=J, age=25), Person(name=K, age=20), Person(name=L, age=22), Person(name=M, age=21)
//    println("arr5: ${arr5}") // Person(name=K, age=20), Person(name=M, age=21), Person(name=L, age=22), Person(name=J, age=25)
//
//    arr4.sortBy { it.age }
//
//    println("arr4: ${arr4.contentToString()}")  // Person(name=K, age=20), Person(name=M, age=21), Person(name=L, age=22), Person(name=J, age=25)
//
//    val arr7 = arr6
//    println("arr6: ${arr6.contentToString()}") // 1, 3, 4, 2, 5
//    arr6.sort()
//    println("arr6: ${arr6.contentToString()}") // 1, 2, 3, 4, 5
//    println("arr7: ${arr7.contentToString()}") // 1, 2, 3, 4, 5
//
//    arr1.sortDe
}

data class Person(val name: String, val age: Int, val height: Int)