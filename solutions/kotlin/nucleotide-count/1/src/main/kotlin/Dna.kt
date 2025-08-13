class Dna(dna: String) {

    private val counts: Map<Char, Int>

    init {
        val validNucleotides = setOf('A', 'C', 'G', 'T')

        if (dna.any { it !in validNucleotides }) {
            throw IllegalArgumentException("Invalid DNA sequence")
        }

        counts = validNucleotides.associateWith { nucleotide ->
            dna.count { it == nucleotide }
        }
    }

    val nucleotideCounts: Map<Char, Int>
        get() = counts
}
