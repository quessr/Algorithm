fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()

        if (n == 0) {
            bw.write("1 0\n")
        } else if (n == 1) {
            bw.write("0 1\n")
        } else {
            var zeroPrev = 1  // f(0)에서 0 출력 횟수
            var onePrev = 0   // f(0)에서 1 출력 횟수
            var zeroCurr = 0  // f(1)에서 0 출력 횟수
            var oneCurr = 1   // f(1)에서 1 출력 횟수

            for (i in 2..n) {
                val newZero = zeroCurr + zeroPrev
                val newOne = oneCurr + onePrev

                zeroPrev = zeroCurr
                onePrev = oneCurr
                zeroCurr = newZero
                oneCurr = newOne
            }
            bw.write("$zeroCurr $oneCurr\n")
        }
    }

    bw.flush()
    bw.close()
}
