fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val dp = IntArray(1001)

    dp[1] = 1
    dp[2] = 3

    for (i in 3..1000) {
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}