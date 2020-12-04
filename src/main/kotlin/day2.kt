
private var input = object {}.javaClass.getResource("day2.txt").readText()

fun main() {
    println(input.lines().filter { it.isNotBlank() }.map {
        val (a, b) = it.split(":")
        val (range, occ) = a.split(" ")
        val (from, to) = range.split("-")
        PasswordMeta(from.toInt(), to.toInt(), occ[0], b.trim())
    }.filter {
        (it.password[it.a - 1] == it.target) xor (it.password[it.b - 1] == it.target)
    }.count())
}

private data class PasswordMeta(
    val a: Int,
    val b: Int,
    val target: Char,
    val password: String
)