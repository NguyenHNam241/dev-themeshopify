object EliudsEggs {

    fun eggCount(number: Int): Int {
        var count = 0
        var n = number
        while (n > 0) {
            if ((n and 1) == 1) { // Kiểm tra bit cuối
                count++
            }
            n = n shr 1 // Dịch phải 1 bit
        }
        return count
    }
}
