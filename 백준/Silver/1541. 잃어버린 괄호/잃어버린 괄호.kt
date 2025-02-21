fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val parts = br.readLine().split("-")

    val firstSum = parts[0].split("+").sumOf { it.toInt() }

    val result = parts.drop(1)
        .map { part -> part.split("+").sumOf { it.toInt() } }
        .fold(firstSum) { acc, num -> acc - num }

    bw.write("$result")

    bw.flush()
    bw.close()
}