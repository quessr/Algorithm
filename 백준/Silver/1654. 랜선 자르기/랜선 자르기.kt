fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val lanCables = LongArray(k) { br.readLine().toLong() } // Long 타입으로 변경

    // 이분 탐색 실행
    val result = binarySearch(lanCables, 1L, lanCables.maxOrNull()!!, n.toLong())

    // 결과 출력
    bw.write("$result")
    bw.flush()
    bw.close()
}

private fun binarySearch(array: LongArray, left: Long, right: Long, target: Long): Long {
    var low = left
    var high = right
    var answer = 0L

    while (low <= high) {
        val mid = (low + high) / 2 // 중간 길이
        val count = array.sumOf { it / mid } // mid 길이로 만들 수 있는 랜선 개수

        if (count >= target) {
            // 목표 개수 이상이면 답 갱신 후 더 긴 길이를 탐색
            answer = mid
            low = mid + 1
        } else {
            // 목표 개수보다 적으면 더 짧은 길이를 탐색
            high = mid - 1
        }
    }

    return answer
}