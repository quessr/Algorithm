fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val dp = IntArray(50001) { it }

    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        var j = 1
        while (j * j <= i) {
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
            j++
        }
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}