fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    var connectionCount = 0

    for (node in 1..n) {
        if (!visited[node]) {
            dfs(node, graph, visited)
            connectionCount++
        }
    }

    bw.write("$connectionCount")

    bw.flush()
    bw.close()
}

private fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
    visited[node] = true

    for (next in graph[node]) {
        if (!visited[next]) {
            dfs(next, graph, visited)
        }
    }
}