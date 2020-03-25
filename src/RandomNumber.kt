import java.util.*

class RandomNumber {

    var rand= Random()



    fun generateMagicNumber() : Int {
        return rand.nextInt(10) + 1
    }

}