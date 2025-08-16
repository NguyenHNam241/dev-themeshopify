import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    constructor(real: Double, imag: Int) : this(real, imag.toDouble())

    operator fun plus(other: ComplexNumber) = ComplexNumber(this.real + other.real, this.imag + other.imag)
    operator fun minus(other: ComplexNumber) = ComplexNumber(this.real - other.real, this.imag - other.imag)
    operator fun times(other: ComplexNumber) = ComplexNumber(
        real = this.real * other.real - this.imag * other.imag,
        imag = this.real * other.imag + this.imag * other.real
    )
    val abs =  sqrt(real*real + imag*imag)
    private fun invert() = ComplexNumber(real / (abs*abs), -imag / (abs*abs))
    operator fun div(other: ComplexNumber) = this * other.invert()
    fun conjugate() = ComplexNumber(real, -imag)
}

fun Double.complex() = ComplexNumber(this, 0)
fun exponential(input: ComplexNumber) = exp(input.real).complex() * ComplexNumber(cos(input.imag), sin(input.imag)
)