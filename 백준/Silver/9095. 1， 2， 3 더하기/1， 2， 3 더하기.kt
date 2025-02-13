fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val cases = IntArray(n) { br.readLine().toInt() }

    for (case in cases) {
        val dp = IntArray(case + 1)
        dp[1] = 1
        if (case >= 2) dp[2] = 2
        if (case >= 3) dp[3] = 4

        for (j in 4..case) {
            dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]
        }
        bw.write("${dp[case]}\n")
    }

    bw.flush()
    bw.close()
}