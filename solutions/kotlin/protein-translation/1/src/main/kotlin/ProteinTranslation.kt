fun translate(rna: String?): List<String> {
    if (rna.isNullOrEmpty()) return emptyList()

    val codonTable = mapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine", "UUC" to "Phenylalanine",
        "UUA" to "Leucine", "UUG" to "Leucine",
        "UCU" to "Serine", "UCC" to "Serine", "UCA" to "Serine", "UCG" to "Serine",
        "UAU" to "Tyrosine", "UAC" to "Tyrosine",
        "UGU" to "Cysteine", "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "STOP", "UAG" to "STOP", "UGA" to "STOP"
    )

    val proteins = mutableListOf<String>()

    rna.chunked(3).forEach { codon ->
        val protein = codonTable[codon] ?: throw IllegalArgumentException("Invalid codon: $codon")
        if (protein == "STOP") return proteins
        proteins.add(protein)
    }

    return proteins
}
