object Isogram {
    fun isIsogram(input: String): Boolean {
        val cleaned = input
            .lowercase()
            .filter { it.isLetter() } // giữ lại chỉ chữ cái

        return cleaned.toSet().size == cleaned.length
    }
}
