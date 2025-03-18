import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }

    var minBacon = Int.MAX_VALUE
    var personWithMinBacon = -1

    for (i in 1..n) {
        val baconSum = bfs(i, graph, n)
        if (baconSum < minBacon || (baconSum == minBacon && i < personWithMinBacon)) {
            minBacon = baconSum
            personWithMinBacon = i
        }
    }
    bw.write("$personWithMinBacon")

    bw.flush()
    bw.close()
}

private fun bfs(start: Int, graph: Array<MutableList<Int>>, n: Int): Int {
    val queue: Queue<Int> = LinkedList()
    val distances = IntArray(n + 1) { -1 }

    queue.offer(start)
    distances[start] = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        for (next in graph[current]) {
            if (distances[next] == -1) {
                queue.offer(next)
                distances[next] = distances[current] + 1
            }
        }
    }

    return distances.sum()
}