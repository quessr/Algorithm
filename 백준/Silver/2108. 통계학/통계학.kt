import kotlin.math.roundToInt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val nList = List(n) { br.readLine().toInt() }

    bw.write(
        "${arithmeticMean(nList)}\n${median(nList)}\n${mode(nList)}\n${
            range(
                nList
            )
        }"
    )

    bw.flush()
    bw.close()
}

//산술평균
fun arithmeticMean(nList: List<Int>): Int {
    return (nList.average()).roundToInt()
}

//중앙값
fun median(nList: List<Int>): Int {
    val sortedList = nList.sorted()
    val centerPoint = nList.size / 2
    return sortedList[centerPoint]
}

//최빈값
fun mode(nList: List<Int>): Int {
    val frequencyMap = nList.groupingBy { it }.eachCount()
    val maxFrequency = frequencyMap.values.max()

    val maxFrequencyKeys = frequencyMap.filter { it.value == maxFrequency }.keys

    return if (maxFrequencyKeys.size > 1) maxFrequencyKeys.sorted()[1] else maxFrequencyKeys.first()
}

//범위
fun range(nList: List<Int>): Int {
    return nList.max() - nList.min()
}
