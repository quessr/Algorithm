fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine()
    val nList = br.readLine().split(" ").map { it.toInt() }
    br.readLine()
    val mList = br.readLine().split(" ").map { it.toInt() }

    val countMap = nList.groupingBy { it }.eachCount()

    mList.forEach { m -> bw.write("${countMap[m] ?: 0} ") }

    bw.flush()
    bw.close()
}