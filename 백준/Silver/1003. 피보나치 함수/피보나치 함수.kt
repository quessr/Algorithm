private val memo = Array(41) { Pair(0, 0) }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val nList = List(n) { br.readLine().toInt() }

    val result = nList.map { fibonacci(it) }

    bw.write(result.joinToString("\n") { "${it.first} ${it.second}" })

    bw.flush()
    bw.close()
}

private fun fibonacci(n: Int): Pair<Int, Int> {
    if (memo[n] != Pair(0, 0)) return memo[n]

    memo[n] = when (n) {
        0 -> Pair(1, 0)
        1 -> Pair(0, 1)
        else -> {
            val (zero1, one1) = fibonacci(n - 1)
            val (zero2, one2) = fibonacci(n - 2)
            Pair(zero1 + zero2, one1 + one2)
        }
    }

    return memo[n]
}