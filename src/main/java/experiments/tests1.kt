package experiments


import InputRunner
import java.io.FileInputStream

fun main() {
    for (i in 1..5) {
        InputRunner(FileInputStream("test_input/ex1.txt"), i.toString())
    }
}