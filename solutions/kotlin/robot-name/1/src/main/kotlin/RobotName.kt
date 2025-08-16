class Robot {

    var name = getName()

    fun reset() {
        name.let {
            name = getName()
            usedNames.remove(it)
        }
    }

    companion object {

        private val usedNames = mutableSetOf<String>()

        private fun getNRandom(n: Int, charRange: CharRange): String =
                (0 until n).joinToString("") { "${charRange.random()}" }

        private fun getName() =
                generateSequence { getNRandom(2, 'A'..'Z') +
                        getNRandom(3, '0'..'9') }
                        .filter { it !in usedNames }.first().also { usedNames.add(it) }
    }
}