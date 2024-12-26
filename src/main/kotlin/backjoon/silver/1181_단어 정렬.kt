package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    /**
     * 1. 길이가 짧은 것부터
     * 2. 길이가 같으면 사전 순으로
     * 3. 중복된 단어는 하나만 남기고 제거
     * */

    val n = br.readLine().toInt()
    val words = mutableListOf<String>()

    repeat(n) {
        words.add(br.readLine())
    }

    val sortedWords = words.distinct().sortedWith(compareBy({ it.length }, { it }))

    bw.write(sortedWords.joinToString("\n"))

    bw.flush()
    bw.close()
}