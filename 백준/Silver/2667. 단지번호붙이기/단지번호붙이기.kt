import java.util.*

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

private val dirR = intArrayOf(1, -1, 0, 0)
private val dirC = intArrayOf(0, 0, 1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    graph = Array(n + 1) { IntArray(n + 1) }
    visited = Array(n + 1) { BooleanArray(n + 1) }

    repeat(n) { i ->
        graph[i + 1] = intArrayOf(0) + br.readLine().map { it.digitToInt() }.toIntArray()
    }

    var aptComplexCnt = 0
    val aptCnt = mutableListOf<Int>()

    for (i in 1..n) {
        for (j in 1..n) {
            if (graph[i][j] == 1 && visited[i][j].not()) {
                aptCnt.add(bfs(i, j, n))
                aptComplexCnt++
            }
        }
    }

    bw.write("$aptComplexCnt\n")
    aptCnt.sorted().forEach { bw.write("$it\n") }

    bw.flush()
    bw.close()
}

private fun bfs(startR: Int, startC: Int, n: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var cnt = 1

    queue.add(Pair(startR, startC))
    visited[startR][startC] = true

    while (queue.isNotEmpty()) {
        var (curR, curC) = queue.poll()

        for (i in 0 until 4) {
            val newR = curR + dirR[i]
            val newC = curC + dirC[i]

            if (newR in 1..n && newC in 1..n && visited[newR][newC].not() && graph[newR][newC] == 1) {
                queue.add(Pair(newR, newC))
                visited[newR][newC] = true
                cnt++
            }
        }
    }
    return cnt
}