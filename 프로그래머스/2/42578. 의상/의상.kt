class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
       var hashMap = HashMap<String, Int>()

        for (clothe in clothes) {
            val type = clothe[1]
            hashMap[type] = hashMap.getOrDefault(type, 0) + 1
        }

        return hashMap.values.fold(1) { acc, value -> acc * (value + 1) } - 1
    }
}