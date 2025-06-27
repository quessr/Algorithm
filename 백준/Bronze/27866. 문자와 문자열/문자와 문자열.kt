fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val s = br.readLine()
    val i = br.readLine().toInt()

    bw.write("${s[i - 1]}\n")

    bw.flush()
    bw.close()
}