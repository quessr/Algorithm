package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var n = br.readLine().toInt()
    var number = 665

    while (n != 0) {
        number++
        if (number.toString().contains("666")) {
            n--
        }
    }

    bw.write(number.toString())

    bw.flush()
    bw.close()
}