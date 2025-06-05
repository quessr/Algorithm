fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val testCases = List(n) { br.readLine().map { it } }

    for (i in 0 until n) {
        var result = 0
        var cnt = 0
        for (j in 0 until testCases[i].size) {
            if (testCases[i][j] == 'O') {
                cnt += 1
                result += cnt
            } else if (testCases[i][j] == 'X') {
                cnt = 0
            }
        }
        bw.write("$result\n")
    }

    bw.flush()
    bw.close()
}