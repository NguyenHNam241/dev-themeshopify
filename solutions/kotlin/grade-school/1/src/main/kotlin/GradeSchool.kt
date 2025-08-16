import java.util.*

class School {

    private val map = mutableMapOf<Int, MutableList<String>>()

    fun add(student: String, grade: Int) {
        map.getOrPut(grade, { mutableListOf() }).add(student)
    }

    fun grade(grade: Int): List<String> {
        return map[grade]?.sorted() ?: emptyList()
    }

    fun roster(): List<String> {
        return map.toList()
            .sortedBy { it.first }
            .flatMap { (_, value) -> value.sorted() }
            .toList()
    }
}