fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val input = br.readLine().toList()

    val alphabetList = ('a'..'z').toList()
    val result = MutableList(26) { -1 }

    input.forEachIndexed { index, ch ->
        val i = alphabetList.indexOf(ch)
        if (result[i] == -1) {
            result[i] = index
        }
    }

    bw.write(result.joinToString(" "))

    bw.flush()
    bw.close()
}