fun transcribeToRna(dna: String): String {
    return dna.map { nucleotide ->
        when (nucleotide) {
            'G' -> 'C'
            'C' -> 'G'
            'T' -> 'A'
            'A' -> 'U'
            else -> throw IllegalArgumentException("Invalid nucleotide: $nucleotide")
        }
    }.joinToString("")
}
