fun day7Part1() {
    val startTime = System.currentTimeMillis()
    //val input = readFileAsLinesUsingUseLines("inputs/Day7.txt")

    val exampleInput = "Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin."

    val input = exampleInput.lines()

    val result = calculateResult(input)

    println("\nResult Day7Part1: $result")
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}

private fun calculateResult(input: List<String>): String {
    val resultArray = ArrayList<Char>()



    return ""
}