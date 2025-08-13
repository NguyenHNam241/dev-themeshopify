object Acronym {
    fun generate(phrase: String): String {
        return phrase
            .replace(Regex("[^A-Za-z- ]"), "")  // remove punctuation except hyphen and spaces
            .split(Regex("[-\\s]+"))            // split on hyphen or whitespace
            .filter { it.isNotEmpty() }
            .map { it.first().uppercaseChar() }
            .joinToString("")
    }
}
