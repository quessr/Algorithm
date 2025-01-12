package backjoon.silver

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val stringList = mutableListOf<String>()

    while (true) {
        var n = br.readLine()
        if (n == ".") break
        stringList.add(n)
    }

    for (string in stringList) {
        val stack = Stack<Char>()
        var isValid = true

        for (char in string) {
            when (char) {
                '(', '[' -> stack.push(char)
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop() // 짝을 맞추면 Pop
                    } else {
                        isValid = false // 짝이 맞지 않음
                        break
                    }
                }

                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') {
                        stack.pop() // 짝을 맞추면 Pop
                    } else {
                        isValid = false // 짝이 맞지 않음
                        break
                    }
                }
            }
        }

        if (isValid && stack.isEmpty()) {
            bw.write("yes\n")
        } else {
            bw.write("no\n")
        }

    }

    bw.flush()
    bw.close()
}