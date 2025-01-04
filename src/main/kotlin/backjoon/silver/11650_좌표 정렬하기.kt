package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val inputList = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        inputList.add(Pair(x, y))
    }

    val sortedList = inputList.sortedWith(compareBy({ it.first }, { it.second }))

    bw.write(sortedList.joinToString("\n") { "${it.first} ${it.second}" })

    bw.flush()
    bw.close()
}