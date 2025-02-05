fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val unheard = HashSet<String>() // 듣도 못한 사람 명단
    val unheardUnseen = mutableListOf<String>() // 듣보잡 명단

    repeat(n) {
        unheard.add(br.readLine())
    }

    repeat(m) {
        val name = br.readLine()
        if (name in unheard) {
            unheardUnseen.add(name)
        }
    }

    unheardUnseen.sort()

    bw.write("${unheardUnseen.size}\n${unheardUnseen.joinToString("\n")}")

    bw.flush()
    bw.close()
}