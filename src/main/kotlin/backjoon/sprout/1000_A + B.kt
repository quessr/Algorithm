package backjoon.sprout

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (a, b) = br.readLine().split(' ').map(String::toInt)
    bw.write("${a + b}")

    bw.flush()
    bw.close()
}