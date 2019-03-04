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



}

fun search(list : List<Grocery>, criteria : (g: Grocery) -> Boolean){
    for (l in list){
        if (criteria(l)){
            println(l.name)
        }
    }
}





