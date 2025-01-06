package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val chessBoard = List(n) { br.readLine() }

    val pattern1 = listOf("BWBWBWBW", "WBWBWBWB")
    val pattern2 = listOf("WBWBWBWB", "BWBWBWBW")

    var minChanges = Int.MAX_VALUE

    for (r in 0..(n - 8)) {
        for (c in 0..(m - 8)) {
            val subBoard = List(8) { i ->
                chessBoard[r + i].substring(c, c + 8)
            }

            val changesForPattern1 = calculateChanges(subBoard, pattern1)
            val changesForPattern2 = calculateChanges(subBoard, pattern2)

            minChanges = minOf(minChanges, changesForPattern1, changesForPattern2)

        }
    }

    bw.write("$minChanges\n")
    bw.flush()
    bw.close()
}

fun calculateChanges(board: List<String>, pattern: List<String>): Int {
    var changes = 0
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] != pattern[i % 2][j]) {
                changes++
            }
        }
    }
    return changes
}