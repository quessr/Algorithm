fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    when (br.readLine().split(" ").joinToString(" ")) {
        "1 2 3 4 5 6 7 8" -> bw.write("ascending")
        "8 7 6 5 4 3 2 1" -> bw.write("descending")
        else -> bw.write("mixed")
    }

    bw.flush()
    bw.close()
}