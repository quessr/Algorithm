fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val sitesAndPasswords = mutableMapOf<String, String>()
    val passwords = mutableListOf<String>()

    repeat(n) {// O(N)
        val (site, password) = br.readLine().split(" ")
        sitesAndPasswords[site] = password
    }

    repeat(m) {// O(M)
        val site = br.readLine()
        if (site in sitesAndPasswords.keys) { // O(1)
            val password = sitesAndPasswords[site]

            password?.let { passwords.add(it) }
        }
    }

    bw.write(passwords.joinToString("\n"))

    // 총 시간 복잡도: O(N + M)

    bw.flush()
    bw.close()
}