import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

private val dirR = intArrayOf(1, -1, 0, 0)
private val dirC = intArrayOf(0, 0, 1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { IntArray(m + 1) }
    visited = Array(n + 1) { BooleanArray(m + 1) }

    repeat(n) { i ->
        graph[i + 1] = intArrayOf(0) + br.readLine().map { it.digitToInt() }.toIntArray()
    }

    bw.write("${bfs(1, 1, n, m)}")

    bw.flush()
    bw.close()
}

private fun bfs(startR: Int, startC: Int, n: Int, m: Int): Int {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    queue.add(Triple(startR, startC, 1))
    visited[startR][startC] = true

    while (queue.isNotEmpty()) {
        val (curR, curC, cnt) = queue.poll()

        if (curR == n && curC == m) return cnt

        for (i in 0 until 4) {
            val newR = curR + dirR[i]
            val newC = curC + dirC[i]

            if (newR in 1..n && newC in 1..m && visited[newR][newC].not() && graph[newR][newC] == 1) {
                queue.add(Triple(newR, newC, cnt + 1))
                visited[newR][newC] = true
            }
        }
    }
    return -1
}