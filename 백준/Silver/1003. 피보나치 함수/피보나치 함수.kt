fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = List(n) { br.readLine().toInt() }
    val maxNumber = numbers.maxOrNull() ?: 0  // 입력된 숫자 중 가장 큰 값

    // 필요할 때만 DP 배열을 초기화
    val zeroDp = IntArray(maxNumber + 1) { 0 }
    val oneDp = IntArray(maxNumber + 1) { 0 }

    zeroDp[0] = 1
    if (maxNumber > 0) oneDp[1] = 1  // maxNumber가 0이면 out of bounds 방지

    for (i in 2..maxNumber) {
        zeroDp[i] = zeroDp[i - 1] + zeroDp[i - 2]
        oneDp[i] = oneDp[i - 1] + oneDp[i - 2]
    }

    val results = numbers.map { "${zeroDp[it]} ${oneDp[it]}" }
    bw.write(results.joinToString("\n"))
    bw.flush()
    bw.close()
}