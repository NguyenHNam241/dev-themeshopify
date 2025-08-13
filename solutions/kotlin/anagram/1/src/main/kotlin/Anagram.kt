class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams
            .filterNot { source.equals(it, true) }
            .filter { source.normalize() == it.normalize() }.toSet()
    }
}

private fun String.normalize() = this.toLowerCase().toCharArray().sorted()

