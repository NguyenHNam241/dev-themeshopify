class Triangle<out T : Number>(a: T, b: T, c: T) {

    private val aD = a.toDouble()
    private val bD = b.toDouble()
    private val cD = c.toDouble()

    init {
        require(aD > 0 && bD > 0 && cD > 0) { "All sides must be greater than 0" }
        require(aD + bD >= cD && bD + cD >= aD && aD + cD >= bD) {
            "Triangle inequality violated"
        }
    }

    val isEquilateral: Boolean
        get() = aD == bD && bD == cD

    val isIsosceles: Boolean
        get() = aD == bD || bD == cD || aD == cD

    val isScalene: Boolean
        get() = aD != bD && bD != cD && aD != cD
}
