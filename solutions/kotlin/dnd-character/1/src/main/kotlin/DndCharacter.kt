import kotlin.random.Random

private const val MIN_DICE_VALUE = 1
private const val MAX_DICE_VALUE = 6
private const val NUMBER_OF_DICE_THROWS = 4
private const val NUMBER_OF_BEST_THROWS = 3
private const val INITIAL_HITPOINTS = 10

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = INITIAL_HITPOINTS + modifier(constitution)

    companion object {

        fun ability(): Int = List(NUMBER_OF_DICE_THROWS) { Random.nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1)}
            .sorted()
            .takeLast(NUMBER_OF_BEST_THROWS)
            .sum()

        fun modifier(score: Int) = score.minus(INITIAL_HITPOINTS).divideBy2()
    }
}

private fun Int.divideBy2() = this.shr(1)