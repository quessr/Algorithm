package backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val a = br.readLine().toInt()

    for (i in 1..a) {
        bw.write(" ".repeat(a - i) + "*".repeat(i) + "\n")
    }

    bw.flush()
    bw.close()
}