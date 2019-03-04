fun main(args : Array<String>) {

    var addFive = {x:Int -> x+5}
    println("Pass 6 to addFive: ${addFive(6)}")

    val addInts = {x:Int, y:Int -> x + y}
    val result = addInts.invoke(6,7)

    val intLambda: (Int, Int) -> Int = {x,y-> y * x}
    println("IntLambda ${intLambda.invoke(6,7)}")

    val addSeven: (Int) -> Int = {it + 7}
    println("Pass 1é to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = {println("YOOO")}

    myLambda()



    var lam4 = {y:Int -> (y/2).toDouble()}
    print(lam4(20))
    lam4 = {it + 6.3}
    print(lam4(7))



    println("Result of convert ${convert(1.0, {it + 4})}.")
    println("Result of convert ${convert(1.0) {it + 5}}.")


    convert5 { (it +4) * 5.1}

    main2()

    val pounds = getConversionLambda("KgsToPounds")(2.5)
    println(pounds)

    println (convert(20.0, getConversionLambda("CentigradeToFarenheit")))

}

typealias DoubleConversion = (Double) -> Double

typealias DuckArray = Array<String>

fun convert(value: Double, converter: DoubleConversion): Double = converter.invoke(value)

fun convert5(converter:(Int) -> Double): Double {
    val result = converter(5)
    println("5 is converted in double: $result")
    return result
}



fun main2(){
    val options = arrayListOf("Red", "Amber", "Green")
    var crosswalk = options[(Math.random() * options.size).toInt()]
    if (crosswalk == "Green"){
        println("Walk")
    }

    unless (crosswalk == "Green") {
        println("Stop")
    }

    unless2 ({crosswalk != "Green"}) {
        println("Stop Again")
    }
}

fun unless(predicate: Boolean, code:()->Unit) {
    if(!predicate){
        code()
    }
}



fun unless2( predicate: () -> Boolean, code:()->Unit) {
    if(predicate()){
        code()
    }
}

fun getConversionLambda(str: String): (Double) -> Double {
    if (str == "CentigradeToFarenheit") {
        return {it * 1.8 + 32}
    }else if (str == "KgsToPounds") {
        return {it * 2.204623}
    }
    else if ( str == "PoundsToUsTons") {
        return  {it/2000.0}
    }
    else return {it}
}

fun combine (lambda1: (Double)-> Double,
             lambda2: (Double) -> Double) : (Double)-> Double {
    return {x: Double ->lambda2(lambda1(x))}

}

fun makeCombines(){
    val kgsToPounds = {x: Double -> x*2.204}
    val poundToUsTons = {x: Double-> x /2000.0}

    val kgsToUsTons = combine(kgsToPounds, poundToUsTons)
    val usTons = kgsToUsTons(1000.0)
}




