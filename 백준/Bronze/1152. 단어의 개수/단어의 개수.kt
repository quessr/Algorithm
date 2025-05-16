fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val string = br.readLine()

    if (string.equals(" ")) bw.write("0") else bw.write("${string.trim().split(" ").count()}")

    bw.flush()
    bw.close()
}