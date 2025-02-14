fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    if (n == 0) return

    repeat(n) {
        val m = br.readLine().toInt()

        val clothes = HashMap<String, Int>() 

        repeat(m) {
            val (_, category) = br.readLine().split(" ")
            clothes[category] = clothes.getOrDefault(category, 0) + 1
        }

        // 각 의상 종류별 (개수 + 1)을 곱한 후, 알몸 상태 제외 (-1)
        val result = clothes.values.fold(1) { acc, num -> acc * (num + 1) } - 1

        bw.write("$result\n")
    }

    bw.flush()
    bw.close()
}