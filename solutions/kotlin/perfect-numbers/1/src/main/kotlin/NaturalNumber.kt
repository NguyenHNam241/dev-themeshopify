import java.lang.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun findFactors(input: Int): List<Int> {
    val results = mutableListOf<Int>()
    var i = 1
    while(i < input) {
        if (input % i == 0) {
            results.add(i)
        }
        i += 1
    }
    return results
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber >= 0)
//    return Classification.DEFICIENT
    val sum = findFactors(naturalNumber).sum()

    if (naturalNumber <= 0) throw RuntimeException(""" """")

    when {
        (sum == naturalNumber) -> return Classification.PERFECT
        (sum > naturalNumber) -> return Classification.ABUNDANT
        else -> {
            return Classification.DEFICIENT
        }
    }
}