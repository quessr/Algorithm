import java.util.LinkedList
import java.util.Queue

private lateinit var campus: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private val dirR = intArrayOf(1, -1, 0, 0)
private val dicC = intArrayOf(0, 0, 1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    campus = Array(n) { br.readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) { false } }

    var startY = 0
    var startX = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (campus[i][j] == 'I') {
                startY = i
                startX = j
            }
        }
    }

    val peopleCount = bfs(startY, startX, n, m)

    bw.write("${if (peopleCount > 0) peopleCount else "TT"}")

    bw.flush()
    bw.close()
}

private fun bfs(startY: Int, startX: Int, n: Int, m: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(startY, startX))
    visited[startY][startX] = true
    var peopleCount = 0

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        if (campus[y][x] == 'P') {
            peopleCount++
        }

        for (dir in 0 until 4) {
            val newY = y + dirR[dir]
            val newX = x + dicC[dir]

            if (newY in 0 until n && newX in 0 until m) {
                if (!visited[newY][newX] && campus[newY][newX] != 'X') {
                    queue.add(Pair(newY, newX))
                    visited[newY][newX] = true
                }
            }
        }
    }
    return peopleCount
}