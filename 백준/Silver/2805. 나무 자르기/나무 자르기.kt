fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (_, m) = br.readLine().split(" ").map { it.toInt() }
    val treeHeights = br.readLine().split(" ").map { it.toInt() }.sorted()

    bw.write("${binarySearch(treeHeights, 0L, treeHeights.maxOrNull()?.toLong() ?: 0L, m.toLong())}\n")

    bw.flush()
    bw.close()
}

private fun binarySearch(array: List<Int>, left: Long, right: Long, target: Long): Long {
    var low = left
    var high = right

    while (low <= high) {
        val mid = (low + high) / 2

        var maxHeightsSum = 0L
        for (height in array) {
            if (height > mid) {
                maxHeightsSum += height - mid
            }
        }

        if (maxHeightsSum >= target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return high
}
