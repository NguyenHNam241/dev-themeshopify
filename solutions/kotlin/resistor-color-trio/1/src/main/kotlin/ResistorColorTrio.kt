import java.lang.StringBuilder

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        var duo: Int
        var allZeros = input[2].ordinal
        if (input[1].ordinal == 0) {
            duo = input[0].ordinal
            allZeros++
        }else{
            duo = input[0].ordinal * 10 + input[1].ordinal
        }
        val unitOrdinal = allZeros / 3
        var remainingZeros = allZeros % 3
        val unit = Unit.values()[unitOrdinal]
        return duo.toString() + "" + convertToNumberOfZeros(remainingZeros) + " " + unit.name.toLowerCase()
    }

    private fun convertToNumberOfZeros(times: Int): String {
        var result = ""
        (1..times).forEach({i -> result = result.plus("0")})
        return result
    }
}