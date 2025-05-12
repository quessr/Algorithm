fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()

    fun number(): Int {
        return a + b - c
    }

    fun string(): Int {
        val abString = a.toString() + b.toString()
        return abString.toInt() - c
    }

    bw.write("${number()}\n${string()}")

    bw.flush()
    bw.close()
}