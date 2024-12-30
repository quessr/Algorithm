package backjoon.silver

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var n = br.readLine().toInt()
    var result = BigInteger.ONE
    var cnt = 0


    while (n != 0) {
        result = result.multiply(BigInteger.valueOf(n.toLong()))
        n--
    }

    val reversedResult = result.toString().reversed()

    for (char in reversedResult) {
        if (char == '0') {
            cnt++
        } else break
    }

    bw.write("$cnt")
//    bw.write("${result.toString().reversed()}")

    bw.flush()
    bw.close()
}