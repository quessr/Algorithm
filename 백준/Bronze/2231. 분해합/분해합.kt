fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    var result = 0

    for (i in 1 until n) { // 0(N)
        if (i + sumOfDigits(i) == n) { // O(logN)
            result = i
            break
        }
    }

    bw.write("$result")

    bw.flush()
    bw.close()
}

fun sumOfDigits(num: Int): Int {
    var sum = 0
    var number = num

    while (number > 0) { // O(logN)
        sum += number % 10
        number /= 10
    }
    return sum
}

// 최종 시간복잡도 = O(NlogN)