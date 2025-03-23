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
const val EMPTY = " "
val COINAMMOUNT = Random.nextInt(from = MINCOINS, until = MAXCOINS)
fun main() {
    val gameBoard = mutableListOf<String>()
    for (i in 1..GAMESQUARES) gameBoard.add(EMPTY)
//make game grid using const
    showGameBoard(gameBoard)


//randomly put an ammount of coins on the play grid using a const for the num of silver coins
}



fun showGameBoard(gameBoard: MutableList<String> = mutableListOf()) {
    println()
    for (i in 0..<gameBoard.size - 1) {
        print("+-------")

    }
    println('+')
    for (i in gameBoard.indices - 1) {
        print("| ${gameBoard[i]}".padEnd(length = 8))
    }
    println('|')
    for (i in 0..<gameBoard.size - 1) {
        print("+-------")
    }
    println('+')
}



