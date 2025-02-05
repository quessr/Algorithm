fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    val values = mutableListOf<Int>()

    repeat(n) {
        values.add(br.readLine().toInt())
    }

    values.sortDescending()

    var cnt = 0

    for (value in values) {
        if (k == 0) break
        if (value > k) continue

        cnt += k / value
        k %= value
    }

    bw.write("$cnt")

    bw.flush()
    bw.close()
}