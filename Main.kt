package indigo

const val SUITS = "♦ ♥ ♠ ♣"
const val RANKS = "A 2 3 4 5 6 7 8 9 10 J Q K"

data class DECK(val size: Int = 52) {
    var deck = arrayOf(size)
    var counter = 0

    fun getCards() {
        println("Number of cards:")
        TODO("Not yet implemented")
    }

    fun shuffleDeck() {
        println("Card deck is shuffled.")
        TODO("Not yet implemented")
    }

    fun fillDeck() {
        println("Card deck is reset.")
        TODO("Not yet implemented")
    }
}

fun main() {
    val deck = DECK()

    do {
        println("Choose an action (reset, shuffle, get, exit):")
        val input = readLine()
        when (input) {
            "reset" -> deck.fillDeck()
            "shuffle" -> deck.shuffleDeck()
            "exit" -> println("Bye")
            "get" -> deck.getCards()
            else -> println("Wrong action.")
        }
    } while (input != "exit")
}
