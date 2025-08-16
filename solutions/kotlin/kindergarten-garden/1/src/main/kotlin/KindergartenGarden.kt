class KindergartenGarden(private val diagram: String) {

    val childRanges = mapOf(
                      "Alice" to 0..1, "Bob" to 2..3, "Charlie" to 4..5, "David" to 6..7, "Eve" to 8..9,
                      "Fred" to 10..11, "Ginny" to 12..13, "Harriet" to 14..15, 
                      "Ileana" to 16..17, "Joseph" to 18..19, "Kincaid" to 20..21, "Larry" to 22..23
                     ) 
    val plants = mapOf("R" to "radishes", "V" to "violets", "C" to "clover", "G" to "grass")

    fun getPlantsOfStudent(student: String): List<String> {
      val range = childRanges.get(student)
      return if(range == null) emptyList<String>()
      else diagram
          .split("\n")
          .map { it.slice(range) }
          .map { it.split("") }
          .flatten()
          .map { plants.get(it) }
          .filterNotNull()
    }
}