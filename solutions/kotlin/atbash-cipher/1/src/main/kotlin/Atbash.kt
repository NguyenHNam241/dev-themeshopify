import javax.xml.stream.events.Characters

object Atbash {
    fun encode(str: String): String {
        var string = str.filter { it.isLetter() || it.isDigit() }.toLowerCase()
        var encode = ""
        var tag =0
        string.forEach {
            if (it.isLetter()){
                encode+=('a'.toInt() + 'z'.toInt() - it.toInt()).toChar().toString()
                tag ++
            }
            else{
                encode+=it
                tag ++
            }
            if (tag != string.length && tag%5 == 0){
                encode+=" "
            }
        }
        return encode
    }

    fun decode(str: String): String {
        var string = str.filter { it.isLetter() || it.isDigit() }.toLowerCase()
        var decode = ""
        var tag =0
        string.forEach {
            if (it.isLetter()){
                decode+=('a'.toInt() + 'z'.toInt() - it.toInt()).toChar().toString()
                tag ++
            }
            else {
                decode += it
                tag++
            }
        }
        return decode
    }
}