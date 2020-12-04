
private var input = object {}.javaClass.getResource("day4.txt").readText()


private val validations = mapOf(
    "byr" to { i: String -> runCatching { i.toInt() in 1920..2002 }.getOrDefault(false)},
    "iyr" to { i: String -> runCatching { i.toInt() in 2010..2020 }.getOrDefault(false)},
    "eyr" to { i: String -> runCatching { i.toInt() in 2020..2030 }.getOrDefault(false)},
    "hgt" to { i: String -> runCatching {
        when {
            i.endsWith("cm") -> {
                i.substring(0, i.length - 2).toInt() in 150..193
            }
            i.endsWith("in") -> {
                i.substring(0, i.length - 2).toInt() in 59..76
            }
            else -> {
                false
            }
        }
    }.getOrDefault(false) },
    "hcl" to { i: String -> Regex("#([0-9]|[a-f]){6}").matches(i) },
    "ecl" to { i: String ->
        val valid = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        valid.any { i == it } },
    "pid" to { i: String -> Regex("[0-9]{9}").matches(i) }
)
private val optional = listOf(
    "cid"
)
fun main() {
    val number = input.split("\n\n").filter { line ->
        val map = line.toMap()
        validations.all {
            val input = map[it.key]
            if (input == null) {
                false
            } else {
                it.value(input)
            }
        }
    }.count()
    println(number)
}

fun String.toMap(): Map<String, String> {
    return split(" ", "\n").map {
        val split = it.split(":")
        if (split.size == 1) {
            split[0] to ""
        } else {
            split[0] to split[1]
        }
    }.toMap()
}