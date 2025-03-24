import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int> {a, b ->
        val absA = kotlin.math.abs(a)
        val absB = kotlin.math.abs(b)
        if (absA == absB) a - b
        else absA - absB
    }

    repeat(n) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (pq.isEmpty()) {
                bw.write("0\n")
            } else {
                bw.write("${pq.poll()}\n")
            }
        } else pq.offer(num)
    }

    bw.flush()
    bw.close()
}