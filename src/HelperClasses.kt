import java.time.LocalDateTime

class Guard(var id: Int, var durationOfSleepInMinutes: Long = 0) {
    var listOfSleeps: ArrayList<Pair<LocalDateTime, LocalDateTime>> = ArrayList()

    override fun toString(): String {
        var string = "\n\nGuardID: $id, duration: $durationOfSleepInMinutes"
        for (sleep in listOfSleeps) {
            string += "\nFrom ${sleep.first} to ${sleep.second}"
        }
        return string
    }
}