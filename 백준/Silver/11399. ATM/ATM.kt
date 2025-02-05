fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine().toInt()
    val times = br.readLine().split(" ").map { it.toInt() }
    val sortedTimes = times.sorted()

    val (totalTime, _) = sortedTimes.fold(0 to 0) { (total, accumulated), time ->
        val newAccumulated = accumulated + time
        total + newAccumulated to newAccumulated
    }

    bw.write("$totalTime")

    bw.flush()
    bw.close()
}