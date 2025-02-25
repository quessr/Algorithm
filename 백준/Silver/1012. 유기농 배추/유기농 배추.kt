lateinit var graph: Array<BooleanArray>
lateinit var visited: Array<BooleanArray>

// 4방향
val dirR = intArrayOf(1, -1, 0, 0)
val dirC = intArrayOf(0, 0, 1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val max = 50 + 10

    repeat(n) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        // M = 열
        // N = 행

        graph = Array(max) { BooleanArray(max) { false } }
        visited = Array(max) { BooleanArray(max) { false } }

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            graph[y + 1][x + 1] = true
        }

        var answer = 0

        for (i in 1..n) {
            for (j in 1..m) {
                if (graph[i][j] && !visited[i][j]) {
                    dfs(i, j)
                    answer++
                }
            }
        }
        bw.write("$answer\n")
    }

    bw.flush()
    bw.close()
}

private fun dfs(y: Int, x: Int) {
    visited[y][x] = true
    for (dirIdx in 0 until 4) {
        val newY = y + dirR[dirIdx]
        val newX = x + dirC[dirIdx]
        if (graph[newY][newX] && !visited[newY][newX]) {
            dfs(newY, newX)
        }
    }
}