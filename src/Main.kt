import java.io.File

fun main(args: Array<String>) {
    day3Part1()
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines {
    it.toList()
}