package backjoon.bronze


/**Solution 1.**/
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val pList = mutableListOf<String>()

    while (true) {
        val input = br.readLine()
        if (input == "0") break
        pList.add(input)
    }

    pList.forEach{p ->
        if (p == p.reversed()) {
            bw.write("yes\n")
        } else {
            bw.write("no\n")
        }
    }

    bw.flush()
    bw.close()
}

/**Solution 2.**/
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//
//    val pList = mutableListOf<String>()
//
//    while (true) {
//        val input = br.readLine()
//        if (input == "0") break
//        pList.add(input)
//    }
//
//    pList.forEach { p ->
//        for (i in 0..p.length / 2) {
//            if (p[i] != p[p.length - 1 - i]) {
//                bw.write("no\n")
//                return@forEach
//            }
//        }
//        bw.write("yes\n")
//    }
//    bw.flush()
//    bw.close()
//}