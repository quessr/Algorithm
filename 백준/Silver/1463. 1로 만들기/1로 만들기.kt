fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)

    for (i in 2..n) {
        dp[i] = minOf(
            dp[i - 1],
            if (i % 2 == 0) dp[i / 2] else Int.MAX_VALUE,
            if (i % 3 == 0) dp[i / 3] else Int.MAX_VALUE
        ) + 1
    }

    bw.write("${dp[n]}\n")

    bw.flush()
    bw.close()
}