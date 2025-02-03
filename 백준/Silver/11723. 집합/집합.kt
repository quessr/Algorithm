var s: MutableSet<Int> = mutableSetOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    repeat(n) {
        val input = br.readLine().split(" ").toMutableList()
        when (input[0]) {
            "add" -> add(input[1].toInt())
            "remove" -> remove(input[1].toInt())
            "check" -> bw.write("${check(input[1].toInt())}\n")
            "toggle" -> toggle(input[1].toInt())
            "all" -> all()
            "empty" -> empty()
        }
    }

    bw.flush()
    bw.close()
}

private fun add(x: Int) {
    s.add(x)
}

private fun remove(x: Int) {
    if (s.contains(x).not()) return
    s.remove(x)
}

private fun check(x: Int): Int {
    return if (s.contains(x)) 1 else 0
}

private fun toggle(x: Int) {
    if (s.contains(x)) s.remove(x) else s.add(x)
}

private fun all() {
    s.clear()
    s.addAll(1..20)
}

private fun empty() {
    s.clear()
    s.addAll(mutableListOf())
}