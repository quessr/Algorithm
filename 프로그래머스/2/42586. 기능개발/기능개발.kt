import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
           var periods = IntArray(progresses.size) {i ->
            ceil((100 - progresses[i]) / speeds[i].toDouble()).toInt()
        }

        val queue = ArrayDeque<Int>()
        periods.forEach { queue.add(it) }

        val answer = mutableListOf<Int>()

        var firstPeriod = queue.removeFirst()
        var cnt = 1

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (firstPeriod >= current) {
                cnt++
            } else {
                answer.add(cnt)
                firstPeriod = current
                cnt = 1
            }
        }

        answer.add(cnt)

        return answer.toIntArray()
    }
}