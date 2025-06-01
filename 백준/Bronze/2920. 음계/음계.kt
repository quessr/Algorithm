fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val input = br.readLine().split(" ")

    when (input.joinToString(" ")) {
        input.sorted().joinToString(" ") -> bw.write("ascending")
        input.sortedDescending().joinToString(" ") -> bw.write("descending")
        else -> bw.write("mixed")
    }

    bw.flush()
    bw.close()
}