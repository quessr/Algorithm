package backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val a = br.readLine().toInt()
    val b = br.readLine().chunked(1)

    var sum = 0

    b.forEach {
        sum += it.toInt()
    }


    bw.write("$sum")

    bw.flush()
    bw.close()
}