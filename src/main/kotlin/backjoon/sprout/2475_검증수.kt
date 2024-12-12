package backjoon.sprout

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = br.readLine().split(' ').map { it.toDouble() }

    val result = numbers.map{ it.pow(2.0).toInt() }.sum() % 10

    bw.write("$result")

    bw.flush()
    bw.close()
}