fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val stairs = IntArray(n) { br.readLine().toInt() }
    val dp = IntArray(n)

    dp[0] = stairs[0]  // 첫 번째 계단
    if (n > 1) dp[1] = stairs[0] + stairs[1]  // 첫 번째 + 두 번째 계단
    if (n > 2) dp[2] = maxOf(stairs[0] + stairs[2], stairs[1] + stairs[2])  // 첫 번째 → 세 번째 vs. 두 번째 → 세 번째

    for (i in 3 until n) {
        dp[i] = maxOf(
            dp[i-2] + stairs[i],      // 두 칸 전에서 오는 경우
            dp[i-3] + stairs[i-1] + stairs[i] // 한 칸 전에서 오면서 `3연속 방지`
        )
    }

    bw.write("${dp[n-1]}")

    bw.flush()
    bw.close()
}