/**
 * @author benjaminmartinez
 * Date: 03/03/2019
 */
data class Grocery(val name: String, val category: String,
val unit: String, val unitPrice: Double, val quantity: Int = 1)


fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes",
        "Vegetable",
        "1b",
        3.0,2),
        Grocery("Mushrooms",
            "Vegetable",
            "1b",
            1.5, 1),
        Grocery("Bagels",
            "Bakery",
            "Pack",
            1.5, 1),
        Grocery("Olive oil",
            "Pantry",
            "Bottle",
            6.0, 3),
        Grocery("Ice Cream", "Frozen",
            "Pack", 3.0, 2))

    println("Expensive ingredients:")
    search(groceries) {i: Grocery -> i.unitPrice > 5}
    println("All Vegetables:")
    search(groceries) {i: Grocery -> i.category == "Vegetable"}
    println("All Packs")
    search(groceries) {i: Grocery -> i.unit == "Pack"}

    println(groceries.maxBy { it.quantity })
    println(groceries.minBy { it.unit })
    println(groceries.sumByDouble { it.quantity * it.unitPrice })
    val vegetables = groceries.filter { it.category =="Vegetable" }.forEach {println(it)}

    val fold = groceries.filterNot { it.category == "Vegetable" }.map { it.quantity * it.unitPrice }
        .fold(0.0) { x: Double, y: Double -> x + y }

    println(fold)

    groceries.groupBy { it.category }.forEach {
      it.value.forEach { grocery: Grocery -> println(grocery) }
    }


    val ints = listOf(1,2,4)
    val sumofInts = ints.fold(0) {a, b -> a+b}

    val productOfInts = ints.fold(1)  {product, b -> product*b}

    val names= groceries.fold("") {sentence, grocerie -> sentence+ "${grocerie.name} "}

    val changeFrom50 = groceries.fold(50.0) {moneyLeft, g -> moneyLeft - (g.unitPrice * g.quantity)}


    val totalPrice = groceries.filter { it.category == "Vegetable" }.map { it.quantity * it.unitPrice }
        .reduce { totalP, currentP -> totalP + currentP }

    val totalPrice2 = groceries.filter { it.category == "Vegetable" }.sumByDouble { it.quantity * it.unitPrice }


    val listOfCheaps : List<String> = groceries.filter { it.unitPrice * it.quantity < 5.0 }.map { it.name }

    groceries.groupBy { it.category }.forEach {
        val total =
            it.value.fold(0.0) { total, grocery -> (total + (grocery.quantity * grocery.unitPrice)) }

        println("First ${it.key} : ${total}")

    }


    groceries.groupBy { it.category }.forEach {
        println(" ${it.key} : ${it.value.sumByDouble { it.unitPrice * it.quantity }}")
    }




    groceries.filterNot { it.unit =="Bottle" }.groupBy { it.unit }.forEach {it.value.forEach { println(it.name) }}


}

 inline fun <T> Iterable<T>.sumByDouble(selector: (T) -> Double): Double {
    val sum = this.mapNotNull { selector(it) }.reduce { acc, d -> acc + d }
    return sum
}


fun search(list : List<Grocery>, criteria : (g: Grocery) -> Boolean){
    for (l in list){
        if (criteria(l)){
            println(l.name)
        }
    }
}





