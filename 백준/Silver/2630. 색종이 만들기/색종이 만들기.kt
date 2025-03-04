lateinit var paper: Array<IntArray>
var whiteCount = 0
var blueCount = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    paper = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    divide(0, 0, n)

    bw.write("$whiteCount\n")
    bw.write("$blueCount")

    bw.flush()
    bw.close()
}

// 현재 영역이 모두 같은 색인지 확인
private fun isUniform(row: Int, column: Int, size: Int): Boolean {
    val firstColor = paper[row][column]
    for (i in row until row + size) {
        for (j in column until column + size) {
            if (paper[i][j] != firstColor) return false
        }
    }
    return true
}

// 4등분하여 재귀 호출
private fun divide(row: Int, column: Int, size: Int) {
    if (isUniform(row, column, size)) {
        if (paper[row][column] == 0) whiteCount++ else blueCount++
        return
    }

    val newSize = size / 2
    divide(row, column, newSize)
    divide(row, column + newSize, newSize)
    divide(row + newSize, column, newSize)
    divide(row + newSize, column + newSize, newSize)
}