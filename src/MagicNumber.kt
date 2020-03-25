import java.util.*

var playAgain = true
var gameLife = 3
val randomNumber = RandomNumber()

fun main(args : Array<String>){
    println("Welcome to my MAGIC NUMBER game")
    startGame()
}

fun startGame() {
    if (gameLife < 1){
        gameLife = 3
    }
    if(playAgain){
        println("I'm thinking of a number ranging from 1 - 10. Guess the number...")
        var scan = Scanner(System.`in`)

        var ans : Int
        try {
            ans = scan.nextInt()
        }catch (e : InputMismatchException){
            println("Invalid input. Please avoid using alphabets and special characters")
            println("waiting for your valid input...")
            ans = scan.nextInt()
        }
        compareAns(ans)
    }
    var scan2 = Scanner(System.`in`)
    println("Try Again? Y for \"Yes\" and N for \"No\" ")
    var response = scan2.nextLine()
    playAgain(response)
}

fun compareAns(ans: Int) {
    var ans = ans
    var scan = Scanner(System.`in`)
    if (randomNumber.generateMagicNumber() == ans){
        println("You won!!!!!")
    }else{
        gameLife -= 1
        println("You guessed wrong!!! :(")
        if(gameLife >= 1){
            println("Life: ${gameLife} \nTry again")
            try {
                ans = scan.nextInt()
            }catch (e : InputMismatchException){
                println("Error: ${e.localizedMessage}")
                var resolved = false
                if (!resolved){
                    println("Please input a number")
                    ans = scan.nextInt()
                    compareAns(ans)
                }
            }
            compareAns(ans)
        }else{
            println("GAME OVER")
        }
    }
}

fun playAgain(response : String){
    when(response.capitalize()){
        "Y" -> {
            playAgain = true
            startGame()
        }
        "N" -> {
            playAgain = false
            println("Thank you for playing...")
        }
        else -> {
            println("Invalid response. Only \"Y\" and \"N\" are allowed.")
            println("Try Again? Y for \"Yes\" and N for \"No\" ")
            var scan3 = Scanner(System.`in`)
            var response = scan3.nextLine()
            playAgain(response)
        }
    }
}
