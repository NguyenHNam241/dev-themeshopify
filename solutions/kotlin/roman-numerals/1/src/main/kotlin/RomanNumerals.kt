object RomanNumerals {

    val thousandsMap = mapOf(
        3 to "MMM",
        2 to "MM",
        1 to "M",
        0 to ""
    )

    val hundredsMap = mapOf(
        9 to "CM",
        8 to "DCCC",
        7 to "DCC",
        6 to "DC",
        5 to "D",
        4 to "CD",
        3 to "CCC",
        2 to "CC",
        1 to "C",
        0 to ""
    )

    val tensMap = mapOf(
        9 to "XC",
        8 to "LXXX",
        7 to "LXX",
        6 to "LX",
        5 to "L",
        4 to "XL",
        3 to "XXX",
        2 to "XX",
        1 to "X",
        0 to ""
    )

    val onesMap = mapOf(
        9 to "IX",
        8 to "VIII",
        7 to "VII",
        6 to "VI",
        5 to "V",
        4 to "IV",
        3 to "III",
        2 to "II",
        1 to "I",
        0 to ""
    )

    fun value(n: Int): String {

        val thousands = n/1000;
        val hundreds = (n-(thousands*1000))/100
        val tens = (n-(thousands*1000)-(hundreds*100))/10;
        val ones = n-(thousands*1000)-(hundreds*100)-(tens*10)

        return thousandsMap[thousands]
            .plus( hundredsMap[hundreds] )
            .plus( tensMap[tens])
            .plus( onesMap[ones])
    }
}