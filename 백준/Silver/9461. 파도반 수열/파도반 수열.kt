fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = IntArray(n) { br.readLine().toInt() }

    val maxNumber = numbers.maxOrNull() ?: 0
    val dp = LongArray(maxNumber + 1)

    if (maxNumber >= 1) dp[1] = 1
    if (maxNumber >= 2) dp[2] = 1
    if (maxNumber >= 3) dp[3] = 1
    if (maxNumber >= 4) dp[4] = 2
    if (maxNumber >= 5) dp[5] = 2

    for (i in 6..maxNumber) {
        dp[i] = dp[i - 1] + dp[i - 5]
    }

    for (number in numbers) {
        bw.write("${dp[number]}\n")
    }

    bw.flush()
    bw.close()
}
