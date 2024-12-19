package backjoon.bronze

val results = mutableListOf<Int>()
val arr = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    /**
     * "N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합"
     *
     * <입력>
     * 5 21
     * 5 6 7 8 9
     *
     * <출력>
     * 21
     *
     * */

    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    arr.addAll(br.readLine().split(" ").map { it.toInt() })

    val addedNum = mutableListOf<Int>()


    fun combination(count: Int = 0, index: Int = 0, depth: Int = 0) {

        if (depth == count) {
            addedNum.add(results.sum())

            return
        }

        for (i in index until arr.size) {
            results.add(arr[i])
            combination(count, i + 1, depth + 1)
            results.removeAt(results.lastIndex)
        }
    }


    combination(count = 3)

    addedNum.sort()

    var answer = 0
    for (num in addedNum.reversed()) {
        if (num <= m) {
            answer = num
            break
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//
//    /**
//     * "N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합"
//     *
//     * <입력>
//     * 5 21
//     * 5 6 7 8 9
//     *
//     * <출력>
//     * 21
//     *
//     * */
//
//    var (n, m) = br.readLine().split(" ").map { it.toInt() }
//    arr.addAll(br.readLine().split(" ").map { it.toInt() })
//
//    val addedNum = mutableListOf<Int>()
//
//
//    fun combination(count: Int = 0, index: Int = 0, depth: Int = 0) {
//
//        if (depth == count) {
//            addedNum.add(results.sum())
//
//            return
//        }
//
//        for (i in index until arr.size) {
//            results.add(arr[i])
//            combination(count, i + 1, depth + 1)
//            results.removeAt(results.lastIndex)
//        }
//    }
//
//
//    combination(count = 3)
//
//
//    while (m > 0) {
//        val found = addedNum.any { it == m }
//        if(found) {
//            bw.write("$m")
//            break
//        } else {
//            --m
//        }
//    }
//
//
//    bw.flush()
//    bw.close()
//}

