fun day3Part1() {
    var input = "#1 @ 1,3: 4x4\n" +
            "#2 @ 3,1: 4x4\n" +
            "#3 @ 5,5: 2x2\n"

    val claims = ArrayList<String>()

    while (input.isNotEmpty()) {
        val claim = input.substring(0, input.indexOf("\n"))
        claims.add(claim)
        input = input.substring(input.indexOf("\n")+1, input.length)
    }

    var fabricArray = arrayOf<Array<Int>>()

    // initialize with 0
    for (i in 0..8) {
        var array = arrayOf<Int>()
        for (j in 0..8) {
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