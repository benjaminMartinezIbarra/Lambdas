import kotlin.math.absoluteValue

/**
 * @author benjaminmartinez
 * Date: 04/03/2019
 */
data class Pizza(val name: String, val pricePerSlice: Double, val quantity: Int)

fun main(args: Array<String>) {

    val ints = listOf(1,2,3,4,5)

    val pizzas = arrayListOf(Pizza("Sunny Chicken", 4.5, 4),
        Pizza("Goat and Nut", 4.0, 1),
        Pizza("Tropical", 3.0, 2),
        Pizza("The garden", 3.5, 3))

    val minInt = ints.minBy { it.absoluteValue }

    val minInt2 = ints.minBy { int: Int-> int }

    val sumInts = ints.sum()

    val sumInts3 = ints.sumByDouble { number: Int -> number.toDouble() }

    val lowPrice = pizzas.minBy { it.pricePerSlice }

    val highQuantity = pizzas.maxBy { p:Pizza-> p.quantity }

    val hQ3 = pizzas.maxBy { it.quantity }

    val totalPrice = pizzas.sumByDouble { it.pricePerSlice * it.quantity }


}