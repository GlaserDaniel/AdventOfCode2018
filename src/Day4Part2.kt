import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

fun day4Part2() {
    val startTime = System.currentTimeMillis()
    var input = readFileAsLinesUsingUseLines("inputs/Day4.txt")
    val result: Int

    /*val testInput = "[1518-11-01 00:00] Guard #10 begins shift\n" +
            "[1518-11-01 00:05] falls asleep\n" +
            "[1518-11-01 00:25] wakes up\n" +
            "[1518-11-01 00:30] falls asleep\n" +
            "[1518-11-01 00:55] wakes up\n" +
            "[1518-11-01 23:58] Guard #99 begins shift\n" +
            "[1518-11-02 00:40] falls asleep\n" +
            "[1518-11-02 00:50] wakes up\n" +
            "[1518-11-03 00:05] Guard #10 begins shift\n" +
            "[1518-11-03 00:24] falls asleep\n" +
            "[1518-11-03 00:29] wakes up\n" +
            "[1518-11-04 00:02] Guard #99 begins shift\n" +
            "[1518-11-04 00:36] falls asleep\n" +
            "[1518-11-04 00:46] wakes up\n" +
            "[1518-11-05 00:03] Guard #99 begins shift\n" +
            "[1518-11-05 00:45] falls asleep\n" +
            "[1518-11-05 00:55] wakes up"

    val input = testInput.lines()*/

    input = input.sorted()

    val guards = ArrayList<Guard>()

    var guard = Guard(0)
    var startSleep = LocalDateTime.now()
    var endSleep: LocalDateTime

    for (line in input) {
        val dateString = line.substring(line.indexOf("[") + 1, line.indexOf("]"))

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.GERMAN)
        val dateTime = LocalDateTime.parse(dateString, formatter)

        //println(date)

        var restString = line.substring(line.indexOf("]") + 2, line.length)

        val firstWord = restString.substring(0, restString.indexOf(" "))

        when {
            firstWord == "Guard" -> {
                restString = restString.substring(restString.indexOf("#"), restString.length)
                val guardId = Integer.parseInt(restString.substring(1, restString.indexOf(" ")))
                var guardFromList: Guard? = null
                for (guardInList in guards) {
                    if (guardInList.id == guardId) {
                        guardFromList = guardInList
                    }
                }
                guard = guardFromList ?: Guard(guardId)
            }
            restString == "falls asleep" -> {
                startSleep = dateTime
            }
            restString == "wakes up" -> {
                endSleep = dateTime
                guard.listOfSleeps.add(Pair(startSleep, endSleep))

                val dur = Duration.between(startSleep, endSleep)
                val millis = dur.toMillis()
                val durInMinutes = TimeUnit.MILLISECONDS.toMinutes(millis)
                guard.durationOfSleepInMinutes += durInMinutes
                if (!guards.contains(guard)) {
                    guards.add(guard)
                }
            }
            else -> println("Something wrong happened: $restString")
        }
    }

    println("Guards: $guards")

    var guardWithMostSleep = Guard(0)
    var timeOfTheMostSleep = 0L

    for (guardInList in guards) {
        if (guardInList.durationOfSleepInMinutes > timeOfTheMostSleep) {
            timeOfTheMostSleep = guardInList.durationOfSleepInMinutes
            guardWithMostSleep = guardInList
        }
    }

    println("\n\nThe Guard who sleep the most: ${guardWithMostSleep.id}")

    val overlapMinutesArray = ArrayList<Int>()

    for (i in 0..60) {
        overlapMinutesArray.add(0)
    }

    for ((index, _) in overlapMinutesArray.withIndex()) {
        for (sleep in guardWithMostSleep.listOfSleeps) {
            if (index >= sleep.first.minute
                && index < sleep.second.minute) {
                overlapMinutesArray[index] += 1
            }
        }
    }

    var minuteItOverlapsTheMost = 0
    var counter = 0

    for ((index, value) in overlapMinutesArray.withIndex()) {
        if (value > counter) {
            counter = value
            minuteItOverlapsTheMost = index
        }
    }

    println("\nMinute it overlaps the most: $minuteItOverlapsTheMost")

    result = guardWithMostSleep.id * minuteItOverlapsTheMost

    println("\nResult Day4Part1: $result")
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}

    /*for (guardInList in guards) {
        if (guardWithMostSleep.id == guardInList.id) {
            for (sleep in guardInList.listOfSleeps) {
                for (otherSleep in guardInList.listOfSleeps) {
                    if (sleep != otherSleep) {
                        if (sleep.first.minute < otherSleep.first.minute
                            && sleep.second.minute > otherSleep.first.minute) {
                            overlapMinutesArray[otherSleep.first.minute] += 1
                        }
                    }
                }
            }
        }
    }*/