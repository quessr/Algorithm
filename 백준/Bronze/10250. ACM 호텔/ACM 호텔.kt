import kotlin.math.ceil

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    for (i in 0 until n) {
        val (h, w, n) = br.readLine().split(" ").map { it.toInt() }

        var floor = n % h

        if (floor == 0) floor = h

        val room =
            if (ceil((n.toDouble() / h)).toInt().toString().length == 1) "0${ceil((n.toDouble() / h)).toInt()}" else {
                ceil((n.toDouble() / h)).toInt()
            }

        bw.write("$floor$room\n")
    }

    bw.flush()
    bw.close()
}