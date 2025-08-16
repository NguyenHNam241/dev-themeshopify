private class Spiral(private val size: Int) {

    val matrix = Array(size) { Array(size) { 0 } }
    var value = 1
    var verticalOffset = 0
    var horizontalOffset = 0

    init {
        fillArray()
    }

    private fun upwards() {
        for (index in matrix.size - 1 downTo 0) {
            insertAtPosition(index, horizontalOffset)
        }
    }

    private fun backward() {
        val backwardsIndex = size - 1 - verticalOffset
        for (index in matrix[backwardsIndex].size - 1 downTo 0) {
            insertAtPosition(backwardsIndex, index)
        }
    }

    private fun downward() {
        matrix.forEachIndexed { index, _ ->
            insertAtPosition(index, size - 1 - horizontalOffset)
        }
    }

    private fun forward() {
        matrix[verticalOffset].forEachIndexed { index, _ ->
            insertAtPosition(verticalOffset, index)
        }
    }

    private fun insertAtPosition(index1: Int, horizontalOffset1: Int) {
        if (matrix[index1][horizontalOffset1] == 0) {
            matrix[index1][horizontalOffset1] = value
            value++
        }
    }

    private fun fillArray() {
        while (value <= (size * size)) {
            forward()
            downward()
            backward()
            verticalOffset++
            upwards()
            horizontalOffset++
        }
    }

}
object SpiralMatrix {
    fun ofSize(size: Int): Array<Array<Int>> {
        if (size == 1)
            return arrayOf(arrayOf(1))

        if (size == 0)
            return emptyArray()

        return Spiral(size).matrix
    }
}