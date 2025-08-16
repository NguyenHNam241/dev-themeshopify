object Prime {

    fun nth(n: Int): Int {
        if (n <= 0) {
            throw IllegalArgumentException("There is no zeroth prime.")
        }

        return generateSequence(1) { it + 1 }.filter { isPrime(it) }.take(n).last()
    }

    private fun isPrime(num: Int): Boolean {
        return when (num) {
            1 -> false
            2 -> true
            else -> !(2..num.div(2)).any { n -> num % n == 0 }
        }
    }
}