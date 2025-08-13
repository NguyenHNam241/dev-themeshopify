import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val inputString = input.toString()
        val digits = inputString.map { it.toString().toInt() }

        val size = digits.size

        val armstrongSum = digits.map { it.toDouble().pow(size) }.sum().toInt()

        return armstrongSum == input
    }

}