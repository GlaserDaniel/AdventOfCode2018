import java.io.File

fun main(args: Array<String>) {
    /*day1Part1()
    day1Part2()
    day2Part1()
    day2Part2()
    day3Part1()
    day3Part2()
    day4Part1()
    day4Part2()*/
    day5Part1()
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines {
    it.toList()
}