import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    /**
     * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS
     * */

    val n = br.readLine().toInt()
    val stringList = List(n) { br.readLine() }

    for (string in stringList) {
        val stack = Stack<Char>()
        var isValid = true

        for (char in string) {
            when (char) {
                '(' -> stack.push(char)
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        isValid = false
                        break
                    }
                }
            }
        }

        if (isValid && stack.isEmpty()) {
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
    }

    bw.flush()
    bw.close()
}