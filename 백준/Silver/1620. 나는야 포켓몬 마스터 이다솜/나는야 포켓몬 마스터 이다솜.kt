fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val pokemonMap = mutableMapOf<String, String>()

    repeat(n) { index ->
        val name = br.readLine()
        val number = (index + 1).toString()
        pokemonMap[name] = number
        pokemonMap[number] = name
    }

    repeat(m) {
        val query = br.readLine()
        bw.write("${pokemonMap[query]}\n")
    }

    bw.flush()
    bw.close()
}