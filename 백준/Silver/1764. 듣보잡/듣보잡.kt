fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val nmNames = mutableListOf<String>()

    repeat(n + m) {
        nmNames.add(br.readLine())
    }

    val groupedNames = nmNames.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.sorted()


    bw.write("${groupedNames.size}\n${groupedNames.joinToString("\n")}")

    bw.flush()
    bw.close()
}