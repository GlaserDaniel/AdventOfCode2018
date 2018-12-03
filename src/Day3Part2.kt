fun day3Part2() {
    val startTime = System.currentTimeMillis()
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

    var temp: Int
    var resultID = 0

    for (claim in claims) {
        temp = 0
        val positionX = Integer.parseInt(claim.substring(claim.indexOf("@")+1, claim.indexOf(",")).trim())
        val positionY = Integer.parseInt(claim.substring(claim.indexOf(",")+1, claim.indexOf(":")))

        val widthX = Integer.parseInt(claim.substring(claim.indexOf(":")+1, claim.indexOf("x")).trim())
        val heightY = Integer.parseInt(claim.substring(claim.indexOf("x")+1, claim.length))

        for (x in positionX until positionX + widthX) {
            for (y in positionY until positionY + heightY) {
                if (fabricArray[y][x] != 1) {
                    temp = 1
                }
            }
        }
        if (temp != 1) {
            resultID = Integer.parseInt(claim.substring(claim.indexOf("#")+1, claim.indexOf("@")-1).trim())
        }
    }

    println("ResultID Day3Part2: $resultID")
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}