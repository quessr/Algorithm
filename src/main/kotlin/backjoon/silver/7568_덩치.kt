package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val weightHeightPairs = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (weight, height) = br.readLine().split(" ").map { it.toInt() }
        weightHeightPairs.add(Pair(weight, height))
    }

//    val results = mutableListOf<Pair<List<Int>, List<List<Int>>>>()

    val resultBuilder = StringBuilder()

    for (i in weightHeightPairs.indices) {
        val currentPair = weightHeightPairs[i]
        val filteredPairs = weightHeightPairs.filterIndexed { index, otherPair ->
            index != i && otherPair.first > currentPair.first && otherPair.second > currentPair.second
        }
//        results.add(currentPair.toList() to filteredPairs.map { it.toList() })

        // 결과 문자열을 StringBuilder에 추가
        resultBuilder.append(filteredPairs.size + 1).append(" ")
    }

//    bw.write(results.map { it.second.size + 1 }.joinToString(" "))
    // 결과를 한 번에 출력
    bw.write(resultBuilder.toString().trim())

    bw.flush()
    bw.close()
}