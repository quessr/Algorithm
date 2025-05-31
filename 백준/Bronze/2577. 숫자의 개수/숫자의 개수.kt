fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val abcList = List(3) {
        br.readLine()
    }

    var multipleAbc = 1

    for (i in abcList.listIterator()) {
        multipleAbc *= i.toInt()
    }

    for (i in 0..9) {
        val arrayMultipleAbc = multipleAbc.toString().map { it.digitToInt() }

        var cnt = arrayMultipleAbc.count { it == i }
        bw.write("$cnt\n")
    }

    bw.flush()
    bw.close()
}