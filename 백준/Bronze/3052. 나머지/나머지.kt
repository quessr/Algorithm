fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val numList = Array(10) { br.readLine() }

    bw.write("${numList.map { it.toInt() % 42 }.toSet().count()}")

    bw.flush()
    bw.close()
}