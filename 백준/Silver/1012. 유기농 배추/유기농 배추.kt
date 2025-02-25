private lateinit var graph: Array<BooleanArray>

private val dirR = intArrayOf(1, -1, 0, 0)
private val dicC = intArrayOf(0, 0, 1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    repeat(n) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val max = 50 + 10

        graph = Array(max) { BooleanArray(max) { false } }

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            graph[y + 1][x + 1] = true
        }

        var answer = 0

        for (i in 1..n) {
            for (j in 1..m) {
                if (graph[i][j]) {
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
    graph[y][x] = false
    for (dirIdx in 0 until 4) {
        val newY = y + dirR[dirIdx]
        val newX = x + dicC[dirIdx]
        if (graph[newY][newX]) {
            dfs(newY, newX)
        }
    }
}