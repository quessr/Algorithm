package backjoon.bronze

import kotlin.random.Random

private val results = mutableListOf<List<Int>>()
private val arr = mutableListOf<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    /**
     * <입력> 5 2
     * <출력> 10
     * */

    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    var comList = mutableListOf<Int>()

    repeat(n) {
        comList.add(Random.nextInt(0, 100))
    }

    fun combination(count: Int, index: Int = 0, depth: Int = 0) {
        if (depth == count) {
            results.add(arr.toList())
            return
        }

        for (i in index until comList.size) {
            arr.add(comList[i])
            combination(count, i + 1, depth + 1)
            arr.removeAt(arr.lastIndex)
        }
    }

    combination(count = m)

    bw.write("${results.size}")

    bw.flush()
    bw.close()

    // 시간복잡도: O(n^m)
}