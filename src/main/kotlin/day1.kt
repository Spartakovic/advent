private var input = object {}.javaClass.getResource("day1.txt").readText()

fun main() {
    val numbers = input.lines().filter { it.isNotBlank() }.map { it.toInt() }

    for (i in numbers.indices - 2) {
        for (j in i + 1 until numbers.size - 2) {
            for (a in j + 1 until numbers.size - 1) {
                if (numbers[i] + numbers[j] + numbers[a] == 2020) {
                    println(numbers[i] * numbers[j] * numbers[a])
                }
            }
        }
    }

}