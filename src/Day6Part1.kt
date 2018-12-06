import kotlin.math.absoluteValue

/*
--- Day 6: Chronal Coordinates ---
The device on your wrist beeps several times, and once again you feel like you're falling.

"Situation critical," the device announces. "Destination indeterminate. Chronal interference detected. Please specify new target coordinates."

The device then produces a list of coordinates (your puzzle input). Are they places it thinks are safe or dangerous? It recommends you check manual page 729. The Elves did not give you a manual.

If they're dangerous, maybe you can minimize the danger by finding the coordinate that gives the largest distance from the other points.

Using only the Manhattan distance, determine the area around each coordinate by counting the number of integer X,Y locations that are closest to that coordinate (and aren't tied in distance to any other coordinate).

Your goal is to find the size of the largest area that isn't infinite. For example, consider the following list of coordinates:

1, 1
1, 6
8, 3
3, 4
5, 5
8, 9
If we name these coordinates A through F, we can draw them on a grid, putting 0,0 at the top left:

..........
.A........
..........
........C.
...D......
.....E....
.B........
..........
..........
........F.
This view is partial - the actual grid extends infinitely in all directions. Using the Manhattan distance, each location's closest coordinate can be determined, shown here in lowercase:

aaaaa.cccc
aAaaa.cccc
aaaddecccc
aadddeccCc
..dDdeeccc
bb.deEeecc
bBb.eeee..
bbb.eeefff
bbb.eeffff
bbb.ffffFf
Locations shown as . are equally far from two or more coordinates, and so they don't count as being closest to any.

In this example, the areas of coordinates A, B, C, and F are infinite - while not shown here, their areas extend forever outside the visible grid. However, the areas of coordinates D and E are finite: D is closest to 9 locations, and E is closest to 17 (both including the coordinate's location itself). Therefore, in this example, the size of the largest area is 17.

What is the size of the largest area that isn't infinite?
*/

fun day6Part1() {
    val startTime = System.currentTimeMillis()
    //val input = readFileAsLinesUsingUseLines("inputs/Day6.txt")
    val result = 0

    val inputString = "1, 1\n" +
            "1, 6\n" +
            "8, 3\n" +
            "3, 4\n" +
            "5, 5\n" +
            "8, 9"

    val input = inputString.lines()

    val coordinates = arrayListOf<Pair<Int, Int>>()

    for (line in input) {
        val coordinateX = Integer.parseInt(line.substring(0, line.indexOf(',')))
        val coordinateY = Integer.parseInt(line.substring(line.indexOf(',') + 2, line.length))
        coordinates.add(Pair(coordinateX, coordinateY))
    }

    val grid = arrayListOf<ArrayList<Int>>()

    for (y in 0..12) {
        val array = arrayListOf<Int>()
        for (x in 0..12) {
            array.add(-1)
        }
        grid += array
    }

    for ((indexY, valueGrid) in grid.withIndex()) {
        for ((indexX, valueArray) in valueGrid.withIndex()) {
            var distance = 400
            for ((indexCoordinate, valueCoordinate) in coordinates.withIndex()) {
                val distanceX: Int = if (valueCoordinate.first >= indexX) {
                    valueCoordinate.first - indexX
                } else {
                    indexX - valueCoordinate.first
                }

                val distanceY: Int = if (valueCoordinate.second >= indexY) {
                    valueCoordinate.second - indexY
                } else {
                    indexY - valueCoordinate.second
                }

                val tempDistance = (distanceX + distanceY).absoluteValue
                if (tempDistance < distance) {
                    distance = tempDistance
                    grid[indexY][indexX] = indexCoordinate + 1
                } else if (tempDistance == distance) {
                    grid[indexY][indexX] = 0
                }
            }
        }
    }



    for (y in grid) {
        for (x in y) {
            print(x)
        }
        println()
    }



    println("\nResult Day6Part1: $result")
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}