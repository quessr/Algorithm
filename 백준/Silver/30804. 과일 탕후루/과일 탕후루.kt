fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine()
    val fruits = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var maxLength = 0
    var countMap = mutableMapOf<Int, Int>()

    for (right in fruits.indices) {
        countMap[fruits[right]] = countMap.getOrDefault(fruits[right], 0) + 1

        while (countMap.size > 2) {
            countMap[fruits[left]] = countMap[fruits[left]]!! - 1
            if (countMap[fruits[left]] == 0) countMap.remove(fruits[left])
            left++
        }

        maxLength = maxOf(maxLength, right - left + 1)
    }

    bw.write("$maxLength\n")
    bw.flush()
    bw.close()
}
