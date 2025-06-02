fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val numList = Array(10) { br.readLine().toInt() }

    bw.write("${numList.map { it % 42 }.toSet().size}")

    bw.flush()
    bw.close()
}