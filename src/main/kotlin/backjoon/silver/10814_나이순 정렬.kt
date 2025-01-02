package backjoon.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    /**
     * 1. 나이순
     * 2. 나이가 같을 시 가입한 순
     *
     * <입력>
     * 3
     * 21 Junkyu
     * 21 Dohyun
     * 20 Sunyoung
     *
     * <출력>
     * 20 Sunyoung
     * 21 Junkyu
     * 21 Dohyun
     *
     * <수도 코드>
     * 1. 입력값을 배열로 받는다
     * 2. 첫번째 인자가 작은순으로 정렬,첫번째인자의 값이 같을경우 두번째 인자 (인덱스값)가 작은순으로 정렬
     * */

    val n = br.readLine().toInt()
    val inputList = mutableListOf<Pair<Int, String>>()

    repeat(n) {
        val (age, name) = br.readLine().split(" ")
        inputList.add(Pair(age.toInt(), name))
    }

    val sortedInputList = inputList.withIndex()
        .sortedWith(compareBy({ it.value.first }, { it.index }))
        .map { it.value }

//    bw.write("inputList: $inputList\n")
//    bw.write("sortedInputList: $sortedInputList")
    bw.write(sortedInputList.joinToString("\n") { "${it.first} ${it.second}" })

    bw.flush()
    bw.close()
}