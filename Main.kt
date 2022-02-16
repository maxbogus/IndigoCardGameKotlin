package indigo

import kotlin.random.Random

const val SUITS = "♦ ♥ ♠ ♣"
const val RANKS = "A 2 3 4 5 6 7 8 9 10 J Q K"

data class DECK(val size: Int = 52) {
    var deck = ArrayDeque<String>(size)

    init {
        fillDeck(true)
    }

    fun getCards(number: Int): MutableList<String> {
        var counter = number
        val hand = mutableListOf<String>()
        if (counter !in 1..52) {
            println("Invalid number of cards.")
        } else {
            if (counter > deck.size) {
                println("The remaining cards are insufficient to meet the request.")
            } else {
                do {
                    hand.add(deck[0])
                    deck.removeFirst()
                    counter -= 1
                } while (counter > 0)
            }
        }
        return hand
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
    println("Indigo Card Game")
    println("Play first?")
    var playerFirst = readLine()!!.lowercase() == "yes"
    val deck = DECK()
    val cardsOnTheTable = deck.getCards(4)
    val playerHand = deck.getCards(6)
    println("Initial cards on the table: ${cardsOnTheTable.joinToString(" ")}")
    var turn = 0

    do {
        println("${cardsOnTheTable.size} cards on the table, and the top card is ${cardsOnTheTable.last()}")
        println("Cards in hand: ${printPlayerHand(playerHand)}")
        println("Choose a card to play (1-${playerHand.size}):")
        val input = readLine()!!
        turn++
    } while (input != "exit")
}

fun printPlayerHand(playerHand: MutableList<String>): String {
    var counter = 1
    var result = mutableListOf<String>()
    repeat(playerHand.size) {
        result += "$counter)${playerHand[counter - 1]}"
        counter++
    }
    return result.joinToString(" ")
}
