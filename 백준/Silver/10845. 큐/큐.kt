val queue = mutableListOf<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    repeat(n) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "push" -> push(input[1].toInt())
            "pop" -> bw.write("${pop()}\n")
            "size" -> bw.write("${size()}\n")
            "empty" -> bw.write("${empty()}\n")
            "front" -> bw.write("${front()}\n")
            "back" -> bw.write("${back()}\n")
        }
    }
    
    bw.flush()
    bw.close()
}

private fun push(data: Int) {
    queue.add(data)
}

private fun pop(): Int {
    return if (queue.isNotEmpty()) queue.removeAt(0) else -1
}

private fun size(): Int {
    return queue.size
}

private fun empty(): Int {
    return if (queue.isEmpty()) 1 else 0
}

private fun front(): Int {
    return if (queue.isNotEmpty()) queue.first() else -1
}

private fun back(): Int {
    return if (queue.isNotEmpty()) queue.last() else -1
}