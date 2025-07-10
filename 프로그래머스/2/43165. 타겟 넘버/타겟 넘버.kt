class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
           var answer = 0

        fun dfs(index: Int, sum: Int): Int {
            if (index == numbers.size) {
                return if (sum == target) answer++ else 0
            }
            return  dfs(index + 1, sum + numbers[index]) + dfs(index + 1, sum - numbers[index])
        }

        dfs(0,0)

        return answer
    }
}