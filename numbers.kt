fun main() {
    val number = mutableListOf<Int>()

    for (i in 1..100) {
        if (i % 2 == 0) {
            number.add(i)
        }
    }

    println(number)
    println("El tama¤o de la lista es: ${number.size}")
}
