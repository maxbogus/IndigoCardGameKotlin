package indigo

import kotlin.random.Random

const val SUITS = "♦ ♥ ♠ ♣"
const val RANKS = "A 2 3 4 5 6 7 8 9 10 J Q K"

data class DECK(val size: Int = 52) {
    var deck = ArrayDeque<String>(size)

    init {
        fillDeck()
    }

    fun getCards() {
        println("Number of cards:")
        TODO("Not yet implemented")
    }

    fun shuffleDeck() {
        val newDeck = deck.toMutableList()
        deck.clear()
        do {
            val index = Random.nextInt(0, newDeck.size)
            val card = newDeck[index]
            deck.add(card)
            newDeck.removeAt(index)
        } while (newDeck.size > 0)
        println("Card deck is shuffled.")
    }

    fun fillDeck() {
        deck.clear()
        val newDeck = mutableListOf<String>()
        for (suit in SUITS.split(" ")) {
            for (rank in RANKS.split(" ")) {
                newDeck.add("$rank$suit")
            }
        }
        do {
            val index = Random.nextInt(0, newDeck.size)
            val card = newDeck[index]
            deck.add(card)
            newDeck.removeAt(index)
        } while (newDeck.size > 0)
        println("Card deck is reset.")
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
