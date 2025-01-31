import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val inputNumbers = IntArray(n) { br.readLine().toInt() }
    val stack = Stack<Int>()
    val result = mutableListOf<String>()

    var currentNumber = 1

    for (target in inputNumbers) {
        // target까지 push
        while (currentNumber <= target) {
            stack.push(currentNumber++)
            result.add("+")
        }

        if (stack.peek() == target) {
            stack.pop()
            result.add("-")
        } else {
            // 스택의 top이 target보다 크다면 만들 수 없는 수열
            bw.write("NO")
            bw.flush()
            bw.close()
            return
        }
    }

    bw.write(result.joinToString("\n"))

    bw.flush()
    bw.close()
}