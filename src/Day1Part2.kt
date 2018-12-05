/*
--- Day 1: Chronal Calibration ---
"We've detected some temporal anomalies," one of Santa's Elves at the Temporal Anomaly Research and Detection Instrument Station tells you. She sounded pretty worried when she called you down here. "At 500-year intervals into the past, someone has been changing Santa's history!"

"The good news is that the changes won't propagate to our time stream for another 25 days, and we have a device" - she attaches something to your wrist - "that will let you fix the changes with no such propagation delay. It's configured to send you 500 years further into the past every few days; that was the best we could do on such short notice."

"The bad news is that we are detecting roughly fifty anomalies throughout time; the device will indicate fixed anomalies with stars. The other bad news is that we only have one device and you're the best person for the job! Good lu--" She taps a button on the device and you suddenly feel like you're falling. To save Christmas, you need to get all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

After feeling like you've been falling for a few minutes, you look at the device's tiny screen. "Error: Device must be calibrated before first use. Frequency drift detected. Cannot maintain destination lock." Below the message, the device shows a sequence of changes in frequency (your puzzle input). A value like +6 means the current frequency increases by 6; a value like -3 means the current frequency decreases by 3.

For example, if the device displays frequency changes of +1, -2, +3, +1, then starting from a frequency of zero, the following changes would occur:

Current frequency  0, change of +1; resulting frequency  1.
Current frequency  1, change of -2; resulting frequency -1.
Current frequency -1, change of +3; resulting frequency  2.
Current frequency  2, change of +1; resulting frequency  3.
In this example, the resulting frequency is 3.

Here are other example situations:

+1, +1, +1 results in  3
+1, +1, -2 results in  0
-1, -2, -3 results in -6
Starting with a frequency of zero, what is the resulting frequency after all of the changes in frequency have been applied?

Your puzzle answer was 437.

--- Part Two ---
You notice that the device repeats the same frequency change list over and over. To calibrate the device, you need to find the first frequency it reaches twice.

For example, using the same list of changes above, the device would loop as follows:

Current frequency  0, change of +1; resulting frequency  1.
Current frequency  1, change of -2; resulting frequency -1.
Current frequency -1, change of +3; resulting frequency  2.
Current frequency  2, change of +1; resulting frequency  3.
(At this point, the device continues from the start of the list.)
Current frequency  3, change of +1; resulting frequency  4.
Current frequency  4, change of -2; resulting frequency  2, which has already been seen.
In this example, the first frequency reached twice is 2. Note that your device might need to repeat its list of frequency changes many times before a duplicate frequency is found, and that duplicates might be found while in the middle of processing the list.

Here are other examples:

+1, -1 first reaches 0 twice.
+3, +3, +4, -2, -4 first reaches 10 twice.
-6, +3, +8, +5, -6 first reaches 5 twice.
+7, +7, -2, -7, -4 first reaches 14 twice.
What is the first frequency your device reaches twice?

Your puzzle answer was 655.
*/

fun day1Part2() {
    val startTime = System.currentTimeMillis()

    val input = " +9 +15 -14 +10 +13 +15 +10 -16 -5 +2 +8 +7 -4 +11 +7 +10 -9 +15 -10 +12 -5 +6 +7 -12 -12 -19 -6 +4 +11 -3 +8 +10 +15 +7 +12 -14 +7 +12 +4 -6 -6 +5 +15 +13 +15 +15 -11 -12 +18 -12 -17 +14 +1 +6 +5 -10 -11 -3 +10 +18 -6 -6 +14 -7 +13 +20 +2 -1 +17 +6 -3 -11 +12 +15 -18 -13 -15 +13 +19 +7 -15 -16 +17 +16 +14 -4 +16 -2 +9 +17 -9 -2 -5 +12 -3 +4 +10 -6 -16 -5 -18 +6 -12 +14 +18 -16 -18 +19 -20 +13 +13 -20 +18 -20 +4 +10 +16 -12 +19 +15 +6 +4 +9 -18 +15 -5 +12 -19 +9 -16 +17 -6 +18 +15 +17 -12 +6 -3 +11 -7 -2 +8 -17 -12 -3 +5 -8 -3 -1 -3 -8 -10 +19 +13 -16 +13 +12 -7 +3 +2 +6 +3 +1 +9 -14 -4 +17 +8 -14 -13 +17 -19 +20 +16 -9 +19 +7 +14 +9 -4 +2 -16 +11 +6 +10 -19 +15 +11 +5 +2 -17 +7 +16 +16 -14 +7 -3 -9 -2 -5 -12 -6 +10 +6 +15 -4 -18 +4 +6 -8 +10 -18 -16 -7 -5 -8 +16 +1 +4 +13 -5 +6 +12 -21 -23 +3 -15 +10 -3 +17 -8 -2 -11 +16 -17 -5 +1 +22 -16 -8 +3 -8 +15 +2 +19 -14 -18 -2 +12 +23 +8 +32 +7 +6 -3 +13 -14 +12 -18 +13 +3 -2 +15 -10 -8 +13 +20 -17 -1 +9 +17 -4 -2 +7 -3 -19 -6 +8 -5 +6 -17 +21 +2 +16 -26 +9 +19 -3 +9 +19 +1 -6 -7 +8 -3 -2 +11 +7 +20 -4 -4 +9 +9 -5 -6 -6 +15 -4 -16 -3 -6 -2 -14 +13 -21 -25 -33 +14 +20 +25 -3 +30 +32 +2 +5 -6 +5 +6 +7 -14 +16 +8 +4 +9 +21 -16 +17 -8 +16 +19 -1 -1 +14 +6 -14 +9 +23 +15 -4 -20 +7 +21 +17 +11 -16 +23 +17 -22 +27 -9 -29 +7 -22 -27 -12 +1 +17 -22 -1 -1 -18 -4 +15 -17 -15 -7 +14 +19 -24 -3 -3 -5 -9 +27 -1 -19 +16 -11 +1 +6 -16 +19 +16 -10 -36 +13 -23 -3 -10 +6 -9 -4 +3 +3 +2 -10 -4 -21 +9 +6 +11 +6 +13 -2 -50 -66 +10 -52 -7 -10 +25 -41 -12 -46 -43 -16 -3 +7 +3 +29 -27 -23 -56 -111 +14 -511 -59243 +6 -3 -11 -6 -15 -10 -13 +8 +17 -4 +19 -8 +4 +17 +8 -5 +4 +14 +4 -6 +15 +4 +21 -17 +12 -31 -70 -10 +6 -11 +13 +11 -5 +2 -15 -19 -20 +14 -11 +5 -12 -3 -17 +4 -8 +5 -10 -14 -13 -2 -9 +10 -11 -21 +12 +1 +11 -21 -15 +4 -6 -14 -13 -5 -7 +6 +10 +14 +6 +14 +2 +8 +18 -15 +18 -13 -19 -20 -19 -16 -18 -7 -1 -12 +14 +15 +14 -4 -16 +19 -9 +16 -12 +3 +6 -15 -10 -10 -15 +11 +20 -23 -19 +1 -12 +3 +17 +4 +3 +17 -9 +1 -2 -19 -11 -5 -14 -1 +11 +3 -6 -1 +14 -11 -5 +18 +9 +2 -9 -16 -12 -13 -1 -7 +12 +4 +11 -22 +14 +23 +6 +11 -9 -9 -4 +17 -8 -10 -16 -10 -4 +7 -9 -14 -14 +12 +10 +13 -16 -13 -18 +19 +10 +10 +20 -5 +8 -27 +16 +7 -5 -8 -20 +8 -19 -7 +16 -22 +9 -19 -19 +15 +16 +18 +7 +10 -16 -6 -18 -2 -7 +8 -7 -20 -2 -2 -19 +18 -4 -18 +8 -19 -16 +3 +17 -12 -10 +3 -17 -15 +19 +4 +3 +16 -1 +13 +6 -15 +14 +19 -3 +16 +1 +5 +3 +1 +8 +12 +7 -18 -16 +23 +6 +3 +6 +13 -15 -22 -13 -16 +19 -9 -7 -13 +2 +25 -19 -16 -4 -27 +19 -21 -7 -23 -19 +17 -8 -3 -10 +1 +16 -6 +15 -8 +17 -16 -14 +11 -10 -10 -16 -6 +2 +1 -17 -19 +17 +12 -11 +7 -13 +15 +15 +10 -9 +3 -1 -1 -20 -1 -9 -13 -13 -10 -15 +17 +4 -9 +16 -4 +17 -14 -11 +17 +20 -11 -2 +19 -20 -21 -4 -8 -7 -6 -16 +15 -12 -13 -4 +16 +4 -14 +9 -18 -12 -19 -12 -19 +9 -15 +8 -12 +8 +8 +16 +6 +10 -5 +2 -17 -13 +24 +26 -11 -17 +37 -3 +14 -5 +4 +16 +3 +12 +4 -25 -18 +7 +16 -11 -22 +11 -19 -11 +23 -21 -14 +26 +17 +19 -29 +33 +45 +14 +9 -22 +10 +7 +13 +9 +12 +9 -20 +3 -9 -19 -18 -23 -7 +34 +11 +46 -16 +21 -8 +18 +10 +7 -15 -7 +1 -16 +28 +16 +2 -8 -3 -3 +39 +15 -10 -3 +6 +17 -27 -19 -10 -43 -42 +133 +19 +19 +27 +59 -14 -18 +5 -10 -7 -21 +108 -41 +53 -309 -42 +123 -1005 -59069 -4 +3 -7 +5 -14 +7 -4 -2 -5 +9 -13 -7 +1 -13 +3 -21 +9 -12 +18 +10 +8 -19 +13 +12 -19 -1 +16 -11 -7 -5 +11 -15 -4 -3 +6 -18 +5 -1 -10 -16 +13 +12 -18 -16 -4 -13 -9 +7 -1 -18 -18 +6 -11 -16 -17 -7 -3 -3 +15 -11 +6 -14 -12 +13 -9 +7 +13 +6 +18 -10 +19 -12 -3 +5 +6 +2 +9 +1 +1 +12 +6 -3 +6 +7 -17 +6 +15 +17 +3 -16 -16 +19 -10 -7 -18 +6 -17 +10 -17 -1 +5 -15 +2 -6 -19 -8 +15 -4 +7 -13 -18 -7 +8 +8 +3 +24 -16 -15 +6 -20 -8 -18 +3 -7 +14 +5 +18 -11 -6 -9 -14 -9 +15 +18 +6 +8 +10 -2 -18 +9 +13 -16 +7 -9 +4 -18 -7 +8 -20 -17 -16 -3 -15 +9 +16 +14 +8 +17 +120917 "

    var tempInput = input

    var result = 0

    val results = ArrayList<Int>()
    results.add(0)

    while(true) {
        //System.out.println(tempInput)
        var temp = tempInput.substring(0,1)

        while (temp == " ") {
            tempInput = tempInput.substring(1, tempInput.length)
            if (tempInput.isEmpty()) {
                tempInput = input
            }
            temp = tempInput.substring(0,1)
        }

        tempInput = tempInput.substring(1, tempInput.length)
        val tempNumb = tempInput.substring(0, tempInput.indexOf(" "))

        //System.out.println(tempNumb)

        if (temp == "+") {
            result += Integer.parseInt(tempNumb)
        } else if (temp == "-") {
            result -= Integer.parseInt(tempNumb)
        }

        tempInput = tempInput.substring(tempInput.indexOf(" ") , tempInput.length)

        if (results.contains(result)) {
            break
        }

        results.add(result)
    }

    System.out.println("result Day1Part2: $result")
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}