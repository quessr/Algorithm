package backjoon.bronze

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var count = 0

    arr.forEach { element ->
        if (element > 1) {
            for (i in 2 until element) {
                if (element % i == 0) {
                    return@forEach
                }
            }
            count++
        }
    }

    bw.write("$count")

    bw.flush()
    bw.close()
}