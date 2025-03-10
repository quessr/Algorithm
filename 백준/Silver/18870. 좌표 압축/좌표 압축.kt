fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine()
    val coordinates = br.readLine().split(" ").map { it.toInt() }

    // 1. 중복 제거 + 정렬된 리스트 생성
    val sortedCoordinates = coordinates.toSortedSet().toList()
    // 2. 정렬된 리스트의 원소별 인덱스 매핑
    val indexMap = sortedCoordinates.withIndex().associate { (index, value) -> value to index }
    // 3. 원본 리스트의 각 값이 정렬된 리스트에서 몇 번째인지 출력
    val result = coordinates.joinToString(" ") { indexMap[it].toString()  }

    bw.write("$result")

    bw.flush()
    bw.close()
}