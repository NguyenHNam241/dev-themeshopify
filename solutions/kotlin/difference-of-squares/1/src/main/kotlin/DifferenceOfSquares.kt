private fun Int.squared() = this * this

class Squares(private val value: Int) {
  fun squareOfSum() = 1.rangeTo(value).sum().squared()
  fun sumOfSquares() = 1.rangeTo(value).map(Int::squared).sum()
  fun difference() = squareOfSum() - sumOfSquares()
}