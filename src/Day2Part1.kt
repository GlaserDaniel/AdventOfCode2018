/*
--- Day 2: Inventory Management System ---
You stop falling through time, catch your breath, and check the screen on the device. "Destination reached. Current Year: 1518. Current Location: North Pole Utility Closet 83N10." You made it! Now, to find those anomalies.

Outside the utility closet, you hear footsteps and a voice. "...I'm not sure either. But now that so many people have chimneys, maybe he could sneak in that way?" Another voice responds, "Actually, we've been working on a new kind of suit that would let him fit through tight spaces like that. But, I heard that a few days ago, they lost the prototype fabric, the design plans, everything! Nobody on the team can even seem to remember important details of the project!"

"Wouldn't they have had enough fabric to fill several boxes in the warehouse? They'd be stored together, so the box IDs should be similar. Too bad it would take forever to search the warehouse for two similar box IDs..." They walk too far away to hear any more.

Late at night, you sneak to the warehouse - who knows what kinds of paradoxes you could cause if you were discovered - and use your fancy wrist device to quickly scan every box and produce a list of the likely candidates (your puzzle input).

To make sure you didn't miss any, you scan the likely candidate boxes again, counting the number that have an ID containing exactly two of any letter and then separately counting those with exactly three of any letter. You can multiply those two counts together to get a rudimentary checksum and compare it to what your device predicts.

For example, if you see the following box IDs:

abcdef contains no letters that appear exactly two or three times.
bababc contains two a and three b, so it counts for both.
abbcde contains two b, but no letter appears exactly three times.
abcccd contains three c, but no letter appears exactly two times.
aabcdd contains two a and two d, but it only counts once.
abcdee contains two e.
ababab contains three a and three b, but it only counts once.
Of these box IDs, four of them contain a letter which appears exactly twice, and three of them contain a letter which appears exactly three times. Multiplying these together produces a checksum of 4 * 3 = 12.

What is the checksum for your list of box IDs?

Your puzzle answer was 5952.
*/

fun day2Part1 () {
    val startTime = System.currentTimeMillis()

    var input = "krdmtuqjmwfoevnadixyclzspv yrdmtuqjiwfoevnabfxyclzsph kqjvtuqjgwfoevnabixyclzsph krdmtuqjgwjoevnaolxyclzsph krdmtnqjgwfoevnabiiyxlzsph lrymtuqjgwhoevnabixyclzsph krdmguqjgwfoevnabixkclzsah krdmtuqjgwfoevnibinyclzdph krdmtucjgwfoevnabhxyclzspv krdmtuqjgwfoevtabixyulzsuh krdmtuqqgwfoevnabixdblzsph krdmtuqjawfsevnabiyyclzsph krdmtuqjgwfoevnabzxccldsph krdmtcqegwfhevnabixyclzsph krdmtuqjgwforvnaxixycgzsph krdmtuqjgwfoqvnaxixyclzskh krdmtutjgwfoevyajixyclzsph krdmtuqmgwfoevnabixycxzspc krdptuqjgwhoevkabixyclzsph krdttuqjhwfoevnabixyclzspa krdmtuqjgwfoevnabibyhnzsph krdmtuqjywfoevntbidyclzsph krdmtojdgwfoevnabixyclzsph krdmtuqjgpfuevnauixyclzsph krdmtoqjgwfrevjabixyclzsph krdmtuqjgwfoyvndbixyclzyph krdmtxqjgwfomvnayixyclzsph crdmtuqjgwfoevnabixyoxzsph krdmtpqjgwfdevnabixycqzsph krdmtuqjgwfoevuabfxsclzsph krdmtuqjgwfoevnybixycdzskh krdmtusjgwfoevnabixxclzdph krdmtuqjgwfoevnaboxyglzjph zrdmtuqjgrfoevnalixyclzsph krdmtuqjclfoevnabixyclzsih kqdmtlqjgwfoevnabtxyclzsph krdmtuqggwpoevnabixyclzlph krdmtuqjgwfobwnrbixyclzsph krdmtuqjgwfoevwabkxycnzsph kldmtuqjgwfogvyabixyclzsph krdmtuqvgwfoevnabixtcrzsph krdmtuqjgwroevnabixyrlzspw krdmtuqjgjfoevnabixyelzrph krdmtuqjgffoevnaaixyclzspa krdmtuqjgwfoevxabifywlzsph krdmtuqjgwfoevlabixycrzsrh krdmtuqjgwfpevnabixocqzsph krdmtuqjgwfoevdabixycnhsph krdmtmqjgwfoevnajixyclvsph krdmtuqjjvfoevnabgxyclzsph krzmtuqjgwfoevnabioyckzsph kodmtwqjgwfoevnabieyclzsph ehdmthqjgwfoevnabixyclzsph krdmtuqjxwioevnabixyclbsph grdmkutjgwfoevnabixyclzsph krdutuqjgwfoebnabixaclzsph krdmtuqjgwfoebnabixyclcjph krdmteqjgwfoevnlbixycizsph krdmtegjgwhoevnabixyclzsph krdmtuqjgwfdrvnabixbclzsph krdmtuqjgyfoevidbixyclzsph krdmtubjawfoevnabixyclzuph krdmtuqjgwfoavjabixyclzssh krdmtuqjgwfoeonabixyclzsvo vrdmtuqjgwffevnabixpclzsph krdmtuqonwfoevnabixycfzsph krdmtumjgwfpevnubixyclzsph krdmtutjgwfoevnaciyyclzsph krdrtuqjgwfoevnwbixyglzsph krdmtuqjgwfoevbabixyclesdh krdmtuqcgwfoevnabixyqdzsph krdmtuqjgwfogvnabrxycezsph krdmujqkgwfoevnabixyclzsph krdmtuqjgtooevnabixyclzzph jrdntuqjgwfoevnabixyclrsph krdmtuqjgzfoevkebixyclzsph krdmtuqjgwfosvnaeixyclztph krdmtuqjgwfoevzabixydlzaph krdmtuqzgwfoavnabiqyclzsph krdmtuqvgwfoevnabixycwzspv krdmvuqjgwteevnabixyclzsph krdmtujjgwfoevgybixyclzsph kydmtuqjgwfoeunacixyclzsph krdmtuqjgifoqvnabicyclzsph krnltiqjgwfoevnabixyclzsph krdmtuqjgwfoevnabhxyclzsgi kfdmtuqjnwfowvnabixyclzsph kmdmtuljgwfoevnabixycvzsph krdmtxqjgwaoevvabixyclzsph kramduqjgwfoevnabixyclzwph krdutuqjgwfoennabixyclziph krdmvuqfgwfoevnacixyclzsph krdmtuqogwfoevnabmvyclzsph krdmfuqjgwfoyvnabixyclzseh krdmtuqjgweoelnabixyclzspd krdmtumjgwfoevnabixyclzypo krdmtuqjgkfoevhabixyclzsqh kjdmtuqjgwfoevgabixyclzsah krdmtuqjgwfoevnlbixyclzsbw mrdmtxqjgwfoevnabgxyclzsph krdmtuqpgwfoevnhbixycltsph krdmtuqjgwfmqvnabixyclzslh krqmtuqogwfoevnaqixyclzsph krdmtusjggfoevnabicyclzsph krcmtuljgwfoevlabixyclzsph krdmtuojgwfoeknabixyclzsrh krdmtuqjtwfoevnabiypclzsph krvmtupjgwfoevnabixycldsph krdmtuxjgwfoevaabxxyclzsph krdmtvqlgwfoehnabixyclzsph wrdmtuqjgwfoevnabixyclzdpy krdatuqlgwfoevnabixyclzsjh krdmtuqjgwfoevpabkxyclzsjh krdmtuqjgwqvsvnabixyclzsph krdmtwqjgwfoevnobixyclzspm krdmtuqjgssoevnabixyclgsph krdmtuqjgwfoevnafixyclzbpp krdmtuqjowfoevxabiuyclzsph krdmtuqrgwfoevntbixyclzspu krdmtucjgwfoevnabixcnlzsph krddtuojgwfoevnabixyclzzph krdmtuqjgwuoevnabiqycldsph kpdmpuqjgwfoevnabixyclzslh krdmtuqjgwfoewnabixyzxzsph krdmtuejswfoevhabixyclzsph krdmtuqggwfoevntbikyclzsph krdmtuqjgwfoevnabixydlhnph krdmtcqjglfoevnaxixyclzsph krumyuqjgwfoevnrbixyclzsph kgdmmuqjgwooevnabixyclzsph krdmteqjgwfqevwabixyclzsph krdmfuqjgwfpevnabixyclzspq erdmtycjgwfoevnabixyclzsph krdmcuqjgwfoevnabixjglzsph krdmtuqjgtfoeunabixiclzsph krdmtuqjgwfoevmqbixyclzspu krlmtuqjvwfoevnabikyclzsph krdotuqjgwfoevnagrxyclzsph krdmtuqbgwfoefnabixyclasph kwdmtuqjgwfosjnabixyclzsph kydmtuqjgwfoevcabixycezsph crdmtuqjgwloevnabixkclzsph krimtuqhgwfoevnbbixyclzsph krdmjuqagwfoevnabicyclzsph krdmtuqdgzfoevnabixydlzsph krdmtuqjgwwoevnaqixyclzspf krdmtuqjgwfoevnabdxyzvzsph krdmtuqjgwaofvnabixyclzsnh krdmturjgwfmevnabixyclzspn krdmvuqjgwboevnabixyolzsph krdmtuqjgwfomvnabijyclzspx bedmtuqjgwfoevnabixyslzsph krdmtenjgwfoevnabixyclzsqh krdmtuqugwfoevnabixpcdzsph krdmtuqjgiloevnabrxyclzsph krdmtupjcwfoevnabixyclwsph kremtuqjgwfoevnabixyyjzsph krdmtuqjgwnoovnabixyclzshh qrdmtuqjgwfoevnabixyciasph krdituqjgbfoevnagixyclzsph krdmnoqjgwfoqvnabixyclzsph krdmtuqegwfoevhkbixyclzsph krdmkucjgwfoevnabixnclzsph krdmtuqbnwpoevnabixyclzsph krdmttqjgwfoevnabixyclbspz srdmtubjgwfrevnabixyclzsph krdmruqjzwfoevnabixyclesph ardmtuqfgwwoevnabixyclzsph yrumtuqjgwhoevnabixyclzsph rrdmtuqjgwfoevnabsxycwzsph krpmtuqjgwfoevdabixyclzzph krdmuuqjgwfoevnabixyclriph krdmtuqjgwfobvnabixyvgzsph krdmbuujgwfoevnabixycczsph krhmtuwjgwfoeqnabixyclzsph krdwtuqjgwfoevnkbixyclzzph krdmtuqjgwkoeqnabixyvlzsph kadmtuqjgwfoednabcxyclzsph krdmtyqqgwfoevnabizyclzsph krdmtuqjgnfoevnabiyycmzsph krdmtuqjcwfouvnabixyclznph krdmtuqjjwfcevnqbixyclzsph krdmtuqfgbfoevgabixyclzsph kkdmtuqjgwfoevnapixyclzsth nrdmtuqjgwtoevnakixyclzsph krdmtuqjglfoevlabixdclzsph zrdmtuqjgwfoevndbixbclzsph krdmeuqjgwfoeenabixyclrsph krdmoaqjzwfoevnabixyclzsph krsmtuqjgwfoevnwbixyclzsfh kadmtuqjgwfoqdnabixyclzsph krsmtuqjgofoevnabixkclzsph krdmtuqjdwfoevnibixdclzsph mrdmtuqjgwfouvnabixyclzfph trdmtlqjgwfoevnabixyclzjph trdmyuqjgwfozvnabixyclzsph krdmtiqjgwroevnabixyclzspk erdmtutjgwftevnabixyclzsph krdwyuqjgwfoevnaaixyclzsph krdmthqbgwfoevnabixyclksph krdmttqjgwfoivnabixyclvsph krdmtuqjgwfoefnabixyflgsph khdmtuqjgwfoevnajixyvlzsph krdmtuqvgwfoevnasixyclzspt krdmtuqjgkwogvnabixyclzsph krdmtuqjgwfoevnaboxpglzjph kadmtuqjgwfoxvnabixyclziph krdmtuqjfwfoevnabaxycbzsph krdjtuqjgwfoevnabiryhlzsph krdvtuqjgpfoevnabcxyclzsph brdmtuqjgwfoevnafixyqlzsph krdmtuqjgwfoevnavixxcllsph krdhtuqjkwfoevfabixyclzsph krdmtuqjgjfoevnawixyclzsuh krddtuqjgwfoeqnabiwyclzsph krhmtuqjgwfnevnabinyclzsph kedmtuqjgzfmevnabixyclzsph qrdmtuqjgwfoevntbixyclzxph krdmtuqsgwfoevnabixvclzrph scdmtuqjgwfoevnabixtclzsph krymtuqjgjfolvnabixyclzsph krdmtuqjgwfkevnablxyclzskh krymtuqjswfoevnabixyclzvph krdmtuqjhwfoevnabixycwzspd krdmtuxjgwfoevnabyxyclzzph krdmtlqjgwfovvnabilyclzsph krdmtuqjgwfoevnaaijcclzsph krdatrqjgwfokvnabixyclzsph krdmtuqjgwfoevnaxifyclzkph krddtuqjgwfoevnabixccozsph krdmtuqngwfoevnabiyycxzsph krdmtumdgwfoevnqbixyclzsph krdmtuqjgwfoevnabixyxlmsch krdmtudzgwfoevnabixtclzsph krdmtuqjgwfoevnpbixyclhspl krdmtqqjgwjoevnabexyclzsph kydmtuqzgwfoevnabixyclwsph krdmeucjgwqoevnabixyclzsph krdmtuqjghfoevjabixyclzspp krdmtuqjgjfwevnabixyclzskh krdmkuhjgwfoevnabipyclzsph krdytuqjgwfoevnabibyclztph krdmtuqjgwfpevnabisyzlzsph kmdmtgqjgwfsevnabixyclzsph krdmtuqjgsfoevnabijyclzszh krdmtuqjgwfoevnabivyclzuuh krdstuqjgrfoevnabixyclzspu jrdmtuqjgwfotvnabixyclzspj krdmrumjgwfoevnabixeclzsph krpmtusjgwfoevnabioyclzsph "

    //var input = "abcdef bababc abbcde abcccd aabcdd abcdee ababab "

    var counter2 = 0

    var counter3 = 0

    while (input.isNotEmpty()) {
        val id = input.substring(0, input.indexOf(" "))
        //println("id: $id")
        val idCharArray = id.toCharArray()
        val letters = ArrayList<Char>()

        var alreadyCount2 = false
        var alreadyCount3 = false

        for (i in idCharArray) {
            var counter = 0
            for (j in idCharArray) {
                if (i == j && !letters.contains(i)) {
                    //println("found a $i")
                    counter++
                }
            }
            if (counter >= 2) {
                //println("counter $i: $counter")
                if (counter == 2 && !alreadyCount2) {
                    counter2++
                    alreadyCount2 = true
                } else if (counter == 3 && !alreadyCount3) {
                    counter3++
                    alreadyCount3 = true
                } else {
                    //println("Something went wrong: $counter")
                }

            }
            letters.add(i)
        }
        input = input.substring(input.indexOf(" ") + 1, input.length)
    }

    println("Result Day2Part1: \nCounter2: $counter2\nCounter3: $counter3\nChecksum: " + counter2*counter3)
    println("Time in Millis: " + (System.currentTimeMillis() - startTime) + "\n")
}