package backjoon.bronze

import kotlin.math.pow

/**Solution 1.**/
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val data = ArrayList<List<String>>()

    while (true) {
        val input = br.readLine().split(" ")
        if (input == listOf("0", "0", "0")) break
        data.add(input)
    }

    val result = data.map {
        val sortedValues = it.map { num -> num.toDouble() }.sorted()
        val a = sortedValues[0].pow(2)
        val b = sortedValues[1].pow(2)
        val c = sortedValues[2].pow(2)

        when {
            a == 0.0 || b == 0.0 || c == 0.0 -> ""
            a + b == c -> "right"
            a + b != c -> "wrong"
            else -> ""
        }
    }

    result.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    bw.close()
}

/**Solution 2.**/
//fun main2() {
//    while (true) {
//        val input = readln().split(" ").map { it.toInt() }
//        if (input.all { it == 0 }) break
//        val c2 = input.maxOf{it}.let{it*it}
//        val a2b2 = input.sumOf{it*it}-c2
//        if (a2b2 == c2) {
//            println("right")
//        } else {
//            println("wrong")
//        }
//    }
//}