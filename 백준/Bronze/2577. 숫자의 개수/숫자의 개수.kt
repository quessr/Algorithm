fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val abcList = List(3) {
        br.readLine()
    }

    var multipleAbc = abcList.fold(1) {acc, s ->  acc * s.toInt()}

    val arrayMultipleAbc = multipleAbc.toString().map { it.digitToInt() }

    for (i in 0..9) {
        var cnt = arrayMultipleAbc.count { it == i }
        bw.write("$cnt\n")
    }

    bw.flush()
    bw.close()
}