package backjoon.bronze

/**Solution 1.**/
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


//    웰컴키트 - 티셔스 한장, 펜 한자루
//    23 참가자의 수 - N
//    3 1 4 1 5 9 - 사이즈별 신청자의 수
//    5 7 - 티셔츠와 펜의 묶음 수 ( T, P )
//    티셔츠는 T(5) 묶음으로만 주문 가능, 펜은 P(7) 묶음으로 주문하거나 한자루씩 주문 가능
//    티셔츠는 남아도 되고(T), 펜은 정확히 참가자 수만큼 (P)

    val n = br.readLine().toInt()
    val tNums = br.readLine().split(' ').map { it.toInt() }
    val pNums = br.readLine().split(' ').map { it.toInt() }

    val tResult = tNums.sumOf {
        if (it % pNums[0] == 0) {
            it / pNums[0]
        } else {
            it / pNums[0] + 1
        }
    }

    val (pResult1, pResult2) = Pair(n / pNums[1], n % pNums[1])

    bw.write("$tResult\n$pResult1 $pResult2")
//    bw.write("n: $n\n tNums: ${tNums.map { it }}\n pNums: ${pNums.map { it }}")

    bw.flush()
    bw.close()
}

/**Solution 2.**/
fun main2() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val shirts = readLine().split(" ").map { it.toInt() }
    val (T, P) = readLine().split(" ").map { it.toInt() }

    var tcnt = 0
    shirts.forEach {
        tcnt += (it / T)
        if (it % T != 0) tcnt++
    }
    println(tcnt)
    println("${n / P} ${n % P}")
}