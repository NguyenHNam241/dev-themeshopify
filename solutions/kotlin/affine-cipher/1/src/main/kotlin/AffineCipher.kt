object AffineCipher {

    var alphabet = CharRange('a', 'z').toList()
    var m = alphabet.size

    fun encode(input: String, a: Int, b: Int): String {
        require(greatestCommonDivisor(a, m) == 1) {
            "a and m must be coprime!"
        }

        return input
                .toLowerCase()
                .filter { it.isLetterOrDigit() }
                .map { if (it.isDigit()) it else alphabet.affineEncode(it, a, b) }
                .joinToString("")
                .chunked(5)
                .joinToString(" ")
    }

    fun decode(input: String, a: Int, b: Int): String {
        require(greatestCommonDivisor(a, m) == 1) {
            "a and m must be coprime!"
        }

        return input
                .toLowerCase()
                .filter { !it.isWhitespace() }
                .map { if (it.isDigit()) it else alphabet.affineDecode(it, a, b) }
                .joinToString("")
    }

    private tailrec fun greatestCommonDivisor(a: Int, b: Int): Int {
        return when {
            b == 0 -> a
            a < b -> greatestCommonDivisor(b, a)
            else -> greatestCommonDivisor(b, a % b)
        }
    }

    private fun List<Char>.affineEncode(value: Char, a: Int, b: Int) = get((a * indexOf(value) + b) % size)
    private fun List<Char>.affineDecode(value: Char, a: Int, b: Int) = get(Math.floorMod(affineDecodeMmi(a) * (indexOf(value) - b), size))
    private fun List<Char>.affineDecodeMmi(a: Int) = IntRange(0, size).first { a * it % size == 1 }
}