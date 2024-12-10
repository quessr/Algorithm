package backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val data = mutableListOf<List<String>>()

    for (i in 0 until n) {
        val a = br.readLine().split(" ")
        data.add(a)
    }

    for (row in data) {
        val repeatNum = row[0].toInt()
        val text = row[1]
        var sum = text.map { char -> char.toString().repeat(repeatNum) }.joinToString("")

        bw.write("$sum \n")
    }

    bw.flush()
    bw.close()
}