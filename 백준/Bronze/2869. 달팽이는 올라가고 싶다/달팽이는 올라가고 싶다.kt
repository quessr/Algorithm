fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (a, b, v) = br.readLine().split(" ").map { it.toInt() }

    if (v == a) {
        bw.write("1")
    } else if ((v - a) % (a - b) == 0) {
        bw.write("${(v - a) / (a - b) + 1}")
    } else bw.write("${(v - a) / (a - b) + 2}")

    bw.flush()
    bw.close()
}