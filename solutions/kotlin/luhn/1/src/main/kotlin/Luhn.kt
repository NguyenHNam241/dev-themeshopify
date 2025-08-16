object Luhn {
    private fun Int.isOdd(): Boolean = this % 2 != 0
    private fun String.areNotJustLuhnSymbols(): Boolean = this.replace("[0-9\\s]".toRegex(), "").isNotEmpty()
    private fun String.removeSpaces(): String = this.replace("\\s".toRegex(), "")
    private fun Int.applyLuhnRuleOver9(): Int = if(this > 9) this -9 else this

    fun isValid(suspect: String): Boolean {
        if (suspect.trim().length <= 1 || suspect.areNotJustLuhnSymbols()) return false
        val luhnCandidate = suspect.removeSpaces().reversed().mapIndexed { i, letter -> applyLuhnRules(i, letter.toString().toInt()) }
        return luhnCandidate.sum() % 10 == 0
    }

    private fun applyLuhnRules(i: Int, digit: Int): Int {
        return when(i.isOdd()) {
            true -> {
                (digit * 2).applyLuhnRuleOver9()
            }
            false -> digit
        }
    }
}