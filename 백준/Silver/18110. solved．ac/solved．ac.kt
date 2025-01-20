import kotlin.math.roundToInt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    if (n == 0) {
        bw.write("0\n") // 의견이 없으면 난이도는 0
    } else {
        val nList = MutableList(n) { br.readLine().toInt() }

        // 상위 및 하위 15% 계산
        val trimCount = (n * 0.15).roundToInt()

        // 리스트 정렬
        val sortedList = nList.sorted()

        // 절사 평균 계산
        val validList = sortedList.subList(trimCount, n - trimCount)
        val average = validList.sum().toDouble() / validList.size

        bw.write("${average.roundToInt()}\n")
    }

    bw.flush()
    bw.close()
}