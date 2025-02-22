fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    var graph = Array(n + 1) { BooleanArray(n + 1) }
    var visited = BooleanArray(n + 1) { false }
    var answer = 0

    fun dfs(idx: Int) {
        visited[idx] = true
        answer++

        for (i in 1..n) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i)
            }
        }
    }

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x][y] = true
        graph[y][x] = true
    }

    dfs(1)

    bw.write("${answer - 1}")

    bw.flush()
    bw.close()
}