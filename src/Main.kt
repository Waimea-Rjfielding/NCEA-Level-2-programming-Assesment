import kotlin.random.Random

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Old Gold Game
 * Project Author: Riley Fielding
 * GitHub Repo:    https://github.com/Waimea-Rjfielding/NCEA-Level-2-programming-Assesment
 * ---------------------------------------------------------------------
 * Notes:
 * Old Gold is a two-player game, played on a one-dimensional grid with coins,
 * where the aim is to win by being the player who removes the gold coin.
 *
 * =====================================================================
 */

const val GAMESQUARES = 20
const val MINCOINS = 5
const val MAXCOINS = 15
const val EMPTY = "    "
val COINAMMOUNT = Random.nextInt(from = MINCOINS, until = MAXCOINS)
const val GOLDCOIN = "GOLD"
const val SILVERCOIN = "SILV"
fun main() {
//make game grid using const
    println(COINAMMOUNT)
    val gameBoard = mutableListOf<String>()
    for (i in 1..GAMESQUARES) gameBoard.add(EMPTY)


//randomly put an ammount of coins on the play grid using a const for the num of silver coins
    placeCoinsInGrid(gameBoard)
    showGameBoard(gameBoard)
    selectCoin(gameBoard)

}
fun placeCoinsInGrid(gameBoard: MutableList<String>) {
    repeat(COINAMMOUNT) {

    var coinPlacement = Random.nextInt(0, GAMESQUARES - 1)

        while(true){
            if (gameBoard[coinPlacement] == EMPTY){
                break
            }
            coinPlacement = Random.nextInt(0, GAMESQUARES - 1)
        }

        gameBoard[coinPlacement] = SILVERCOIN



    }

    var coinPlacement = Random.nextInt(0, GAMESQUARES - 1)

    while(true){
        if (gameBoard[coinPlacement] == EMPTY){
            break
        }
        coinPlacement = Random.nextInt(0, GAMESQUARES - 1)
    }

    gameBoard[coinPlacement] = GOLDCOIN

}


fun showGameBoard(gameBoard: MutableList<String> = mutableListOf()) {
    println()
    for (i in 0..<gameBoard.size) {

        print("+------")

    }
    println("+")
    for (i in gameBoard.indices) {
        print("| ${i + 1} ".padEnd(7))
    }
    println("|")

    for (i in 0..<gameBoard.size) {
        print("+------")

    }
    println('+')
    for (i in gameBoard.indices) {
        print("| ")
        when(gameBoard[i]) {
            SILVERCOIN -> print(gameBoard[i].black().bgGrey())
            GOLDCOIN -> print(gameBoard[i].black().bgYellow())
            EMPTY -> print(gameBoard[i].black())

        }
        print(" ")
    }
    println('|')
    for (i in 0..<gameBoard.size) {
        print("+------")
    }
    println('+')
}

fun selectCoin(gameBoard: MutableList<String> = mutableListOf()) {

}


