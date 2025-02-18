fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (_, m) = br.readLine().split(" ").map { it.toInt() }
    val nList = br.readLine().split(" ").map { it.toInt() }

    val prefixSum = IntArray(nList.size + 1) { 0 }
    for (i in nList.indices) {
        prefixSum[i + 1] = prefixSum[i] + nList[i]
    }

    repeat(m) {
        val (l, r) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${prefixSum[r] - prefixSum[l - 1]}\n")
    }

    bw.flush()
    bw.close()
}