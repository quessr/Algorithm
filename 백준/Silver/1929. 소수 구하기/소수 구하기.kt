import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    bw.write("${sieveOfEratosthenes(m, n).joinToString("\n")}")

    bw.flush()
    bw.close()
}

fun sieveOfEratosthenes(m: Int, n: Int): List<Int> {
    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }
    return isPrime.mapIndexed { index, prime -> if (prime && index >= m) index else null }.filterNotNull()
}