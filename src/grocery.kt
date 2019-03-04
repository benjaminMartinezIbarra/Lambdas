/**
 * @author benjaminmartinez
 * Date: 03/03/2019
 */
data class Grocery(val name: String, val category: String,
val unit: String, val unitPrice: Double)


fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoes",
        "Vegetable",
        "1b",
        3.0),
        Grocery("Bagels",
            "Bakery",
            "Pack",
            1.5),
        Grocery("Olive oil",
            "Pantry",
            "Bottle",
            6.0),
        Grocery("Ice Cream", "Frozen",
            "Pack", 3.0))

    println("Expensive ingredients:")
    search(groceries) {i: Grocery -> i.unitPrice > 5}
    println("All Vegetables:")
    search(groceries) {i: Grocery -> i.category == "Vegetable"}
    println("All Packs")
    search(groceries) {i: Grocery -> i.unit == "Pack"}

}

fun search(list : List<Grocery>, criteria : (g: Grocery) -> Boolean){
    for (l in list){
        if (criteria(l)){
            println(l.name)
        }
    }
}

fun myFun1(x: Int = 6, y: (Int) -> Int = {7}): Int =

     y(x)



fun myFun2(x: Int = 6, y: (Int) -> Int = { it }): Unit {

     y(x)

}

fun myFun3(x: Int = 6, y: (Int) -> Int = { x: Int -> x + 6 }): Int {

    return y(x)

}

fun myFun4(x: Int, y: Int,

           z: (Int, Int) -> Int = {

                   x: Int, y: Int -> x + y

           }) {

    z(x, y)

}

fun myFun5(x: (Int) -> Int = {

    println(it)

    it + 7

}) {

    x(4)

}



