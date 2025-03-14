fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m, b) = br.readLine().split(" ").map { it.toInt() }

    var graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var minTime = Int.MAX_VALUE
    var bestHeight = 0

    for (targetHeight in 0..256) {
        var remove = 0
        var add = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                val diff = graph[i][j] - targetHeight
                if (diff > 0) remove += diff
                else add -= diff
            }
        }

        if (remove + b >= add) {
            val time = remove * 2 + add
            if (time < minTime || (time == minTime && targetHeight > bestHeight)) {
                minTime = time
                bestHeight = targetHeight
            }
        }
    }

    bw.write("$minTime $bestHeight")

    bw.flush()
    bw.close()
}