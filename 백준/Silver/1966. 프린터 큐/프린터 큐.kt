import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val l = br.readLine().toInt()

    repeat(l) {
        val (_, m) = br.readLine().split(" ").map { it.toInt() }
        val priorities = br.readLine().split(" ").map { it.toInt() }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        priorities.forEachIndexed { index, value ->
            queue.add(value to index)
        }

        var printOrder = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (queue.any { it.first > current.first }) {
                queue.add(current)
            } else {
                printOrder++
                if (current.second == m) {
                    bw.write("$printOrder\n")
                    break
                }
            }
        }
    }

    bw.flush()
    bw.close()
}