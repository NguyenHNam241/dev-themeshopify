class BowlingGame {
    val rounds: MutableList<Pair<Int,Int?>> = mutableListOf()

    fun roll(pins: Int) {
        check(pins in 0..10) { "pins in 0..10" }

        check(
            rounds.size < 10
                    || rounds.size == 10 && rounds[ID_LAST].second == null
                    || rounds.size == 10 && (isSpare(ID_LAST) || isStrike(ID_LAST))
                    || rounds.size == 11 && isStrike(ID_LAST) && isStrike(10)
                    || rounds.size == 11 && isStrike(ID_LAST) && rounds[10].second == null
        ) { "can't roll: $rounds" }

        if (rounds.isNotEmpty() && rounds.last().first != 10 && rounds.last().second == null) {
            rounds.removeLast().let { rounds.add(Pair(it.first,pins)) }
            check(rounds.last().let { it.first + (it.second ?: 0) <= 10 }) { "error score: $rounds" }
        }
        else
            rounds.add(Pair(pins,null))
    }

    fun score(): Int {
        println(rounds)
        check(
            rounds.size == 10 && !isSpare(ID_LAST) && !isStrike(ID_LAST) && rounds[ID_LAST].second != null
                    || rounds.size == 11 && isSpare(ID_LAST) && rounds[10].second == null
                    || rounds.size == 11 && isStrike(ID_LAST) && (scoreRound(10) < 10 || rounds[10].second != null)
                    || rounds.size == 12 && isStrike(ID_LAST) && isStrike(10)
        ) { "error size: $rounds" }

        return (0..ID_LAST).map { i ->
            when {
                isStrike(i) -> {
                    scoreRound(i) +
                            if (isStrike(i+1))
                                rounds[i+1].first + rounds[i+2].first
                            else
                                scoreRound(i+1)
                }
                isSpare(i) -> scoreRound(i) + rounds[i+1].first
                else -> scoreRound(i)
            }
        }.sum()
    }

    private fun isStrike(index: Int): Boolean =
        rounds[index].first == SCORE_MAX

    private fun isSpare(index: Int): Boolean =
        rounds[index].second != null && scoreRound(index) == SCORE_MAX

    private fun scoreRound(index: Int): Int =
        rounds[index].first + (rounds[index].second ?: 0)

    companion object {
        const val ID_LAST = 9
        const val SCORE_MAX = 10
    }
}

fun main() {
    //println(listOf(1,2,3) + 5 + listOf(6,7))

    //val list = listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val list = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3)
    val b = BowlingGame()
    list.forEach { b.roll(it) }
    println(b.score())
}