
class NumberSpeller {
    fun say(input: Long): String {
        require(input in 0..999_999_999_999)
        if (input == 0L)
            return "zero"

        val hundreds = (input % 1_000).toInt()
        val thousands = ((input / 1_000) % 1_000).toInt()
        val millions = ((input / 1_000_000) % 1_000).toInt()
        val billions = ((input / 1_000_000_000) % 1_000).toInt()

        val sb = StringBuilder()
        if (billions != 0)
            sb.append(chunkWord(billions)).append(" billion ")
        if (millions != 0)
            sb.append(chunkWord(millions)).append(" million ")
        if (thousands != 0)
            sb.append(chunkWord(thousands)).append(" thousand ")
        if (hundreds != 0)
            sb.append(chunkWord(hundreds)).append(" ")
        sb.deleteCharAt(sb.length - 1)
        return sb.toString()
    }

    private fun chunkWord(chunk: Int): String {
        require(chunk in 1..999)  // this function does NOT handle zero
        val onesDigit = chunk % 10
        val tensDigit = (chunk / 10) % 10
        val tens = chunk % 100
        val hundredsDigit = (chunk / 100) % 10

        val sb = StringBuilder()
        if (hundredsDigit != 0)
            sb.append(lt20Words[hundredsDigit]).append(" hundred ")

        // check for non-concatenating numbers (less than 20) and return early
        if (tens in 1..19) {
            sb.append(lt20Words[tens])
            return sb.toString()
        }

        if (tensDigit >= 2)
            sb.append(tensWords[tensDigit]).append("-")
        if (onesDigit > 0)
            sb.append(lt20Words[onesDigit]).append(" ")
        sb.deleteCharAt(sb.length - 1)
        return sb.toString()
    }

    private val lt20Words = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

    private val tensWords = listOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
}