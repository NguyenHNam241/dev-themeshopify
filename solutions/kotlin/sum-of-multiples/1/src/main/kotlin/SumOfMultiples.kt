object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return (1 until limit) // all numbers less than limit
            .filter { num -> 
                factors.any { factor -> factor != 0 && num % factor == 0 }
            }
            .sum()
    }
}
