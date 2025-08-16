package Sieve

fun primesUpTo(n: Int): List<Int> {
    var values = (2 .. n).toMutableList()
    var i = 0
    while (i < values.count()) {
        val p = values[i]
        ((2*p) .. n step p).forEach { values.remove(it)  }
        i += 1
    }
    return values
}