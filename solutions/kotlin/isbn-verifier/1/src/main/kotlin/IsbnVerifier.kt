class IsbnVerifier {
    fun isValid(isbn: String) = isbn.replace("-".toRegex(), "")
            .matches("^[0-9]{9}[0-9X]$".toRegex()) &&
            isbn.filter { it == 'X' || it.isDigit() }
                    .foldIndexed(0) {
                        index: Int, sum: Int, digit: Char ->
                        sum + (10 - index) * if (digit == 'X') 10 else digit - '0'
                    } % 11 == 0
}