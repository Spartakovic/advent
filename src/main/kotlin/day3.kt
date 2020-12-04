private var input = object {}.javaClass.getResource("day3.txt").readText()

fun main() {
    val map = input.lines().filter { it.isNotBlank() }
    val width = map[0].length
    val height = map.size

    val pairs = listOf(
        1 to 1,
        3 to 1,
        5 to 1,
        7 to 1,
        1 to 2
    )

    var number = 1

    for ((X, Y) in pairs) {
        var x = 0
        var y = 0
        var curr = 0
        while (y < height) {

            if (x > width - 1) {
                x %= width
            }

            if (map[y][x] == '#') {
                curr += 1
            }

            y += Y
            x += X
        }
        println(curr)
        number *= curr
    }
    println(number)
}