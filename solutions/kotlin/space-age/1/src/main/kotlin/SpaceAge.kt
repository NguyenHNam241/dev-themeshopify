import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(private val seconds: Int) {

    fun onEarth(): Double =  formulaPlanet(1.0)

    fun onMercury(): Double = formulaPlanet(0.2408467)

    fun onVenus(): Double = formulaPlanet(0.61519726)

    fun onMars(): Double = formulaPlanet(1.8808158)
    fun onJupiter(): Double = formulaPlanet(11.862615)
    fun onSaturn(): Double = formulaPlanet(29.447498)
    fun onUranus(): Double = formulaPlanet(84.016846)
    fun onNeptune(): Double = formulaPlanet(164.79132)

    private fun formulaPlanet(argument: Double) :Double =
            ((((seconds/60)/60)/24)/(365.25 * argument)).round()
}
fun Double.round() =
        BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toDouble()