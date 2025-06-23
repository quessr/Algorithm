fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    var sum = 0
    var cnt = 0
    var value = 1

    while (sum < n ){
        sum += value
        cnt++
        value = if (cnt == 1) 6 else value + 6
    }

    bw.write("$cnt")

    bw.flush()
    bw.close()
}