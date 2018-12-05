/*
--- Day 4: Repose Record ---
You've sneaked into another supply closet - this time, it's across from the prototype suit manufacturing lab. You need to sneak inside and fix the issues with the suit, but there's a guard stationed outside the lab, so this is as close as you can safely get.

As you search the closet for anything that might help, you discover that you're not the first person to want to sneak in. Covering the walls, someone has spent an hour starting every midnight for the past few months secretly observing this guard post! They've been writing down the ID of the one guard on duty that night - the Elves seem to have decided that one guard was enough for the overnight shift - as well as when they fall asleep or wake up while at their post (your puzzle input).

For example, consider the following records, which have already been organized into chronological order:

[1518-11-01 00:00] Guard #10 begins shift
[1518-11-01 00:05] falls asleep
[1518-11-01 00:25] wakes up
[1518-11-01 00:30] falls asleep
[1518-11-01 00:55] wakes up
[1518-11-01 23:58] Guard #99 begins shift
[1518-11-02 00:40] falls asleep
[1518-11-02 00:50] wakes up
[1518-11-03 00:05] Guard #10 begins shift
[1518-11-03 00:24] falls asleep
[1518-11-03 00:29] wakes up
[1518-11-04 00:02] Guard #99 begins shift
[1518-11-04 00:36] falls asleep
[1518-11-04 00:46] wakes up
[1518-11-05 00:03] Guard #99 begins shift
[1518-11-05 00:45] falls asleep
[1518-11-05 00:55] wakes up
Timestamps are written using year-month-day hour:minute format. The guard falling asleep or waking up is always the one whose shift most recently started. Because all asleep/awake times are during the midnight hour (00:00 - 00:59), only the minute portion (00 - 59) is relevant for those events.

Visually, these records show that the guards are asleep at these times:

Date   ID   Minute
            000000000011111111112222222222333333333344444444445555555555
            012345678901234567890123456789012345678901234567890123456789
11-01  #10  .....####################.....#########################.....
11-02  #99  ........................................##########..........
11-03  #10  ........................#####...............................
11-04  #99  ....................................##########..............
11-05  #99  .............................................##########.....
The columns are Date, which shows the month-day portion of the relevant day; ID, which shows the guard on duty that day; and Minute, which shows the minutes during which the guard was asleep within the midnight hour. (The Minute column's header shows the minute's ten's digit in the first row and the one's digit in the second row.) Awake is shown as ., and asleep is shown as #.

Note that guards count as asleep on the minute they fall asleep, and they count as awake on the minute they wake up. For example, because Guard #10 wakes up at 00:25 on 1518-11-01, minute 25 is marked as awake.

If you can figure out the guard most likely to be asleep at a specific time, you might be able to trick that guard into working tonight so you can have the best chance of sneaking in. You have two strategies for choosing the best guard/minute combination.

Strategy 1: Find the guard that has the most minutes asleep. What minute does that guard spend asleep the most?

In the example above, Guard #10 spent the most minutes asleep, a total of 50 minutes (20+25+5), while Guard #99 only slept for a total of 30 minutes (10+10+10). Guard #10 was asleep most during minute 24 (on two days, whereas any other minute the guard was asleep was only seen on one day).

While this example listed the entries in chronological order, your entries are in the order you found them. You'll need to organize them before they can be analyzed.

What is the ID of the guard you chose multiplied by the minute you chose? (In the above example, the answer would be 10 * 24 = 240.)

Your puzzle answer was 99911.

--- Part Two ---
Strategy 2: Of all guards, which guard is most frequently asleep on the same minute?

In the example above, Guard #99 spent minute 45 asleep more than any other guard or minute - three times in total. (In all other cases, any guard spent any minute asleep at most twice.)

What is the ID of the guard you chose multiplied by the minute you chose? (In the above example, the answer would be 99 * 45 = 4455.)

Your puzzle answer was 65854.
*/

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap

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

    // HashMap
    // [ID] [[minute] [value]]
    val overlappingMinutesArray = HashMap<Int, HashMap<Int, Int>>()

    // initialize with 0
    for (guardInGuards in guards) {
        overlappingMinutesArray[guardInGuards.id] = HashMap(60)
        for (j in 0..60) {
            overlappingMinutesArray[guardInGuards.id]?.set(j, 0)
        }
    }

    for (guardInList in guards) {
        for (sleep in guardInList.listOfSleeps) {
            for (i in 0..60) {
                if (i >= sleep.first.minute
                    && i < sleep.second.minute
                ) {
                    overlappingMinutesArray[guardInList.id]?.set(i,
                        overlappingMinutesArray[guardInList.id]?.get(i)!!.plus(1)
                    )
                }
            }
        }
    }

    var guardIdOfMostMinutes = 0
    var minuteTheGuardSleep = 0
    var counter = 0

    for ((guardIdIndex, minutesValues) in overlappingMinutesArray) {
        for ((minuteIndex, value) in minutesValues) {
            if (value > counter) {
                counter = value
                guardIdOfMostMinutes = guardIdIndex
                minuteTheGuardSleep = minuteIndex
            }
        }
    }

    println("\nGuard: $guardIdOfMostMinutes \nMinute it overlaps the most: $minuteTheGuardSleep ")

    result = minuteTheGuardSleep * guardIdOfMostMinutes

    println("\nResult Day4Part2: $result")
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