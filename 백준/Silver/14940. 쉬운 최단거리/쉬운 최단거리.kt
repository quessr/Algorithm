import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { IntArray(m + 1) }

    var targetX = -1
    var targetY = -1

    for (i in 1..n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..m) {
            graph[i][j] = line[j - 1]
            if (graph[i][j] == 2) {
                targetY = i
                targetX = j
            }
        }
    }

    val dist = bfs(n, m, targetY, targetX)
    val sb = StringBuilder()
    for (i in 1..n) {
        for (j in 1..m) {
            if (graph[i][j] == 0) sb.append(0).append(" ")
            else sb.append(dist[i][j]).append(" ")
        }
        sb.append("\n")
    }

    bw.write(sb.toString())

    bw.flush()
    bw.close()
}

private fun bfs(n: Int, m: Int, ty: Int, tx: Int): Array<IntArray> {
    val dist = Array(n + 1) { IntArray(m + 1) { -1 } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val dirY = intArrayOf(1, -1, 0, 0)
    val dirX = intArrayOf(0, 0, 1, -1)

    queue.add(Pair(ty, tx))
    dist[ty][tx] = 0

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny in 1..n && nx in 1..m && graph[ny][nx] == 1 && dist[ny][nx] == -1) {
                dist[ny][nx] = dist[y][x] + 1
                queue.offer(Pair(ny, nx))
            }
        }
    }
    return dist
}