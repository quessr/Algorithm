fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()

    val homes = mutableListOf<Pair<Int, Int>>()

    // dp[k][n] = dp[k][n - 1] + dp[k - 1][n]

    repeat(t) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()

        val dp = Array(k + 1) { IntArray(n + 1) }

        for (i in 1..n) {
            dp[0][i] = i
        }

        for (floor in 1..k) {
            for (room in 1..n) {
                dp[floor][room] = dp[floor][room - 1] + dp[floor - 1][room]
            }
        }

        bw.write("${dp[k][n]}\n")
    }

    bw.flush()
    bw.close()
}