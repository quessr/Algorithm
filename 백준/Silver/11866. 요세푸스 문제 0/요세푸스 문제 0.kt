import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList()

    for (i in 1..n) {
        queue.add(i)
    }

    val result = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        repeat(k - 1) {
            queue.add(queue.poll())
        }
        result.add(queue.poll())
    }

    bw.write("<${result.joinToString(", ")}> ")

    bw.flush()
    bw.close()
}