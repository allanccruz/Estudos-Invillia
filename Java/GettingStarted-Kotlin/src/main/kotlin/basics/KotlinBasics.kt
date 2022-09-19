package basics


class Person (var name: String, var age: Int) {
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}
var allan = Person ("Allan", 26);

class Car (var collor: String, var year: Int, var owner: Person) {

}
var car = Car("Black", 2022, allan);

fun buyingCar(name: String, carCollor: String) {
    return println("${name} is buying a ${carCollor} car!")
}

fun evenOrOdd (number: Int) {
    if (number % 2 == 0) println("Number ${number} is even!") else println("Number ${number} is odd!")
}

fun printOneToTen() {
    for (number in 1..10) { println(number)}
}

fun printEvenOneToTen() {
    for (number in 2..10 step 2) {
        println(number)
    }
}

fun whileLessThanTen() {
    var i = 0
    while (i <= 10) {
        println(i)
        i++
    }
}

fun doWhileLessThanTen() {
    var i = 0
    do {
        println(i)
        i++
    } while (i <= 10)
}

fun whenCase () {
    var x = 5
    when (x) {
        5 -> println("x == 5")
        8 -> println("x == 8")
    }
}

var list = mutableListOf(3, 4, 1, 5, 3, 2, 5);

var setNumbers = list.toSet();

var mapNameAndAge = mutableMapOf("Allan" to 26, "Matheus" to 24);

class TestingCompanionObject {
    companion object {
        fun sayingByeBye() {println("Thanks for testing me! Bye bye!")}
    }
}

fun main() {

    buyingCar(allan.name, car.collor);
    println();

    evenOrOdd(2);
    evenOrOdd(5);
    println();

    printOneToTen();
    println();

    printEvenOneToTen();
    println();

    whileLessThanTen();
    println();

    doWhileLessThanTen();
    println();

    whenCase();
    println();

    println(list);
    list.add(6);
    println(list);
    println();

    list.forEach {
        println(it)
    };
    println();

    list.sort();
    println(list);
    list.shuffle();
    println(list);
    println();

    println(setNumbers);
    println();

    println(mapNameAndAge);
    mapNameAndAge.put("Bruno", 30);
    println(mapNameAndAge);
    mapNameAndAge.remove("Bruno");
    println(mapNameAndAge);
    println();

    TestingCompanionObject.sayingByeBye();
}