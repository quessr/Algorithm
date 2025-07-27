class Solution {
    fun solution(s: String): String {
        val input = s.split(" ").map { it.toInt() }
        return "${input.minOf { it }} ${input.maxOf { it }}"
    }
}