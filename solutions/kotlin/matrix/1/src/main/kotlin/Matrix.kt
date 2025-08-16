// 01-10-20

// 64 ms
class Matrix(matrixAsString: String) {
  private val mat: List<List<Int>> =
    matrixAsString.replace("[ ]+".toRegex(), " ")
      .split("\n")
      .map { it.trim().split(" ").map { it.toInt() }.toList() }
      .toList()

  fun row(row: Int): List<Int> = mat[row - 1]

  fun column(col: Int): List<Int> = mat.map { it[col - 1] }
}