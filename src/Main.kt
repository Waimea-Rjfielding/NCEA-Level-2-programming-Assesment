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
 * =====================================================================
 */
const val GAMESQUARES = 20
const val MINCOINS = 5
const val MAXCOINS = 10
const val EMPTY = "    "
val COINAMMOUNT = Random.nextInt(from = MINCOINS, until = MAXCOINS)
const val GOLDCOIN = "GOLD"
const val SILVERCOIN = "SILV"
var turns = 1


fun main() {
    //make game grid using const
    val gameBoard = mutableListOf<String>()
    for (i in 1..GAMESQUARES) gameBoard.add(EMPTY)
    //randomly put an ammount of coins on the play grid using a const for the num of silver coins
    placeCoinsInGrid(gameBoard)
    println("Instructions!")
    println("To play Old Gold, the aim is to be the player whom removes the gold coin.")
    println("You do this by moving the gold coin to the right and eventually getting it to square 20 and then removing it.")
    println("When it is in square 20, you input an zero when the program prompts you with where you would like to move the coin")
    print("Player 1 name:")
    val playerOneName = readln()
    print("Player 2 name:")
    val playerTwoName = readln()

    while (true){
        if (turns == 1){
            println("$playerOneName, its your go!")
        }
        else if (turns == 2){
            println("$playerTwoName, its your go!")
        }
        else{
            var turns = 1
        }
        showGameBoard(gameBoard)
        val selected = selectCoin(gameBoard) - 1
        val destination = whereMoveCoin(gameBoard, playerOneName, playerTwoName) - 1
        if (destination >= selected && checkMove(gameBoard, destination, selected)){
            moveCoin(gameBoard, destination, selected)
            if (turns == 1){
                turns = 2
            }
            else{
                turns = 1
            }
        } else {
            if (destination == 0 || destination == -1){
                if (turns == 1){
                    turns = 2
                }
                else{
                    turns = 1
                }
            }
            else{
                println("Invalid move!")
            }
        }
    }
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
    println("+")
    for (i in gameBoard.indices) {
        print("| ")
        when(gameBoard[i]) {
            SILVERCOIN -> print(gameBoard[i].black().bgGrey())
            GOLDCOIN -> print(gameBoard[i].black().bgYellow())
            EMPTY -> print(gameBoard[i].black())
        }
        print(" ")
    }
    println("|")
    for (i in 0..<gameBoard.size) {
        print("+------")
    }
    println("+")
}

fun selectCoin(gameBoard: MutableList<String> = mutableListOf()): Int {
    println()
    print("Which box contains the coin you would like to move: ")
    var selectedCoin = readln().toIntOrNull()
    if (selectedCoin != null) {
        if (gameBoard[selectedCoin-1] != EMPTY) {
            return (selectedCoin)
        }
        else
            println("Box has no coin!")
        return selectCoin(gameBoard)
    }
    else
        println("Enter a number!")
        return selectCoin(gameBoard)
}

fun whereMoveCoin(gameBoard: MutableList<String> = mutableListOf(), playerOneName: String, playerTwoName: String): Int {
    println()
    print("Enter where you would like to move coin: ")
    var moveTo = readln().toIntOrNull()
    if (moveTo == 0) {
        val box20 = gameBoard[19]
        if (box20 == GOLDCOIN) {
            if (turns == 1){
                println("Congratulations $playerOneName! You won!")
            }
            else{
                println("Congratulations $playerTwoName! You won!")
            }
            gameBoard[19] = EMPTY
            kotlin.system.exitProcess(0)
        }
        if (box20 == SILVERCOIN) {
            gameBoard[19] = EMPTY
            return 0
        }
        return whereMoveCoin(gameBoard, playerOneName, playerTwoName)
    }
    if (moveTo != null) {
        if (gameBoard[moveTo-1] == EMPTY) {
            return (moveTo)
        }
        else {
            println("Box is full!")
            return whereMoveCoin(gameBoard, playerOneName, playerTwoName)
        }
    }
    else {
        println("Enter a number!")
        return whereMoveCoin(gameBoard, playerOneName, playerTwoName)
    }
}

fun moveCoin(gameBoard: MutableList<String> = mutableListOf(), destination: Int?, selected: Int): MutableList<String> {
    gameBoard[destination!!] = gameBoard[selected]
    gameBoard[selected] = (EMPTY)
    return(gameBoard)
}

fun checkMove(gameBoard: MutableList<String> = mutableListOf(), destination: Int, selected: Int): Boolean {
    for (i in (selected + 1)..destination) {
        if (gameBoard[i] != EMPTY) {
            return false
        }
    }
    return true
}