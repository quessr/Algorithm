import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val intList = List(n) { br.readLine().toInt() }

    val stack = Stack<Int>()

    for (int in intList) {
        when (int) {
            0 -> if (stack.isNotEmpty()) stack.pop()
            else -> stack.push(int)
        }
    }

    if (stack.isEmpty()) bw.write("0") else bw.write("${stack.sum()}")

    bw.flush()
    bw.close()
}