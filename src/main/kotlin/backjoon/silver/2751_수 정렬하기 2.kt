package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    var nList = mutableListOf<Int>()
    repeat(n) {
        nList.add(br.readLine().toInt())
    }
    nList.sort()

    bw.write("${nList.joinToString("\n")}")
    bw.flush()
    bw.close()
}