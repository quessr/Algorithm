package backjoon.silver

import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
        visited[node] = true
        bw.write("$node ")

        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited)
            }
        }
    }

    fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            bw.write("$current ")

            for (next in graph[current]) {
                if (!visited[next]) {
                    queue.add(next)
                    visited[next] = true
                }
            }
        }
    }

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    val visitedDFS = BooleanArray(n + 1)
    dfs(v, graph, visitedDFS)
    bw.write("\n")

    val visitedBFS = BooleanArray(n + 1)
    bfs(v, graph, visitedBFS)

    bw.flush()
    bw.close()
}
