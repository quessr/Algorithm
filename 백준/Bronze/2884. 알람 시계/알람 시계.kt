fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var (h, m) = br.readLine().split(" ").map { it.toInt() }

    if (h == 0 && m < 45) h = 24

    bw.write("${(h * 60 + m - 45) / 60} ${(h * 60 + m - 45) % 60}")

    bw.flush()
    bw.close()
}