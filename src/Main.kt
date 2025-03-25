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
const val EMPTY = "BLNK"
val COINAMMOUNT = Random.nextInt(from = MINCOINS, until = MAXCOINS)
const val GOLDCOIN = "GOLD"
const val SILVERCOIN = "SILV"
fun main() {
//make game grid using const
    val gameBoard = mutableListOf<String>()
    for (i in 1..GAMESQUARES) gameBoard.add(EMPTY)


//randomly put an ammount of coins on the play grid using a const for the num of silver coins
    placeCoinsInGrid(gameBoard)
    showGameBoard(gameBoard)
    selectCoin(gameBoard)

}
fun placeCoinsInGrid(gameBoard: MutableList<String>) {
    repeat(COINAMMOUNT) {
        var coinPlacement = Random.nextInt(from = 0, until = GAMESQUARES - 1)
        gameBoard[coinPlacement] = SILVERCOIN.black().bgGrey()

    }
    gameBoard[Random.nextInt(from = 0, until = GAMESQUARES - 1)] = GOLDCOIN.black().bgYellow()
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
        print("| ${gameBoard[i]} ")
    }
    println('|')
    for (i in 0..<gameBoard.size) {
        print("+------")
    }
    println('+')
}

fun selectCoin(gameBoard: MutableList<String> = mutableListOf()) {

}


