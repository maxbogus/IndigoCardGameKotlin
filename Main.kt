package indigo

import java.lang.Exception
import kotlin.random.Random

const val SUITS = "♦ ♥ ♠ ♣"
const val RANKS = "A 2 3 4 5 6 7 8 9 10 J Q K"

data class DECK(val size: Int = 52) {
    var deck = ArrayDeque<String>(size)

    init {
        fillDeck(true)
    }

    fun getCards() {
        println("Number of cards:")
        var input = 0
        try {
            input = readLine()!!.toInt()
        } catch (_: Exception) {
        }
        if (input !in 1..52) {
            println("Invalid number of cards.")
        } else {
            if (input > deck.size) {
                println("The remaining cards are insufficient to meet the request.")
            } else {
                val hand = mutableListOf<String>()
                do {
                    hand.add(deck[0])
                    deck.removeFirst()
                    input -= 1
                } while (input > 0)
                println(hand.joinToString(" "))
            }
        }
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

    fun fillDeck(init: Boolean = false) {
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
        if (!init) {
            println("Card deck is reset.")
        }
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
