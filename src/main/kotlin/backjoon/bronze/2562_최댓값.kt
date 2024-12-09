package backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val maxNums = mutableListOf<Int>()
    repeat(9) {
        val b = br.readLine().toInt()
        maxNums.add(b)
    }

    val (max, maxLine) = findMax(maxNums)

    bw.write("$max\n")
    bw.write("$maxLine\n")

    bw.flush()
    bw.close()
}

fun findMax(list: List<Int>): Pair<Int, Int> {
    var max = Int.MIN_VALUE
    var maxLine = -1
    for ((index, value) in list.withIndex()) {
        if (value > max) {
            max = value
            maxLine = index + 1
        }
    }
    return Pair(max, maxLine)
}