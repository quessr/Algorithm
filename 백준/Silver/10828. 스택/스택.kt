val stack = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    repeat(n) {
        val input = br.readLine().split((" "))
        when (input[0]) {
            "push" -> push(input[1].toInt())
            "pop" -> bw.write("${pop()}\n")
            "size" -> bw.write("${size()}\n")
            "empty" -> bw.write("${empty()}\n")
            "top" -> bw.write("${top()}\n")
        }
    }


    bw.flush()
    bw.close()
}

fun push(data: Int) {
    stack.add(data)
}

fun pop(): Int {
    return if (stack.isNotEmpty()) stack.removeAt(stack.size - 1) else -1
}

fun size(): Int {
    return stack.size
}

fun empty(): Int {
    return if (stack.isEmpty()) 1 else 0
}

fun top(): Int {
    return if (stack.isNotEmpty()) stack.last() else -1
}