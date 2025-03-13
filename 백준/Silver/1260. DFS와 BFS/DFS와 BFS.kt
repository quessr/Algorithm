import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    visited = BooleanArray(n + 1)
    bw.write(dfs(v, graph, visited) + "\n")

    visited = BooleanArray(n + 1)
    bw.write(bfs(v, graph, visited) + "\n")

    bw.flush()
    bw.close()
}

private fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): String {
    val result = StringBuilder()

    fun dfsHelper(current: Int) {
        visited[current] = true
        result.append("$current ")

        for (next in graph[current]) {
            if (visited[next].not()) {
                dfsHelper(next)
            }
        }
    }
    dfsHelper(node)

    return result.toString()
}

private fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): String {
    val queue: Queue<Int> = LinkedList()
    val result = StringBuilder()

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        result.append("$current ")

        for (next in graph[current]) {
            if (visited[next].not()) {
                queue.offer(next)
                visited[next] = true
            }
        }
    }

    return result.toString()
}