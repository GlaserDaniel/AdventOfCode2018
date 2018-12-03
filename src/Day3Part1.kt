fun day3Part1() {
    val claims = readFileAsLinesUsingUseLines("inputs/Day3Part1.txt")

    var fabricArray = arrayOf<Array<Int>>()

    // initialize with 0
    for (i in 0..1000) {
        var array = arrayOf<Int>()
        for (j in 0..1000) {
            array += 0
        }
        fabricArray += array
    }

    for (claim in claims) {
        val positionX = Integer.parseInt(claim.substring(claim.indexOf("@")+1, claim.indexOf(",")).trim())
        val positionY = Integer.parseInt(claim.substring(claim.indexOf(",")+1, claim.indexOf(":")))

        val widthX = Integer.parseInt(claim.substring(claim.indexOf(":")+1, claim.indexOf("x")).trim())
        val heightY = Integer.parseInt(claim.substring(claim.indexOf("x")+1, claim.length))

        for (x in positionX until positionX + widthX) {
            for (y in positionY until positionY + heightY) {
                fabricArray[y][x] += 1
            }
        }
    }

    var result = 0

    for (array in fabricArray) {
        for (value in array) {
            //print(value)
            if (value >= 2) {
                result++
            }
        }
        //println()
    }

    println("\nResult: $result")
}