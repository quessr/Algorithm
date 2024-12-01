import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(br.readLine().toInt()) { index ->
        bw.write("Line $index: ${br.readLine()}\n")
    }
    bw.flush()
    bw.close()
}