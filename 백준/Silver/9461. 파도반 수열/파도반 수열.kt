fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = IntArray(n) { br.readLine().toInt() }

    val dp = LongArray(101)

    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for (i in 4..100) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }

    for (number in numbers) {
        bw.write("${dp[number]}\n")
    }

    bw.flush()
    bw.close()
}