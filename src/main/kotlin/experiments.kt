
fun main() {
    val nums = intArrayOf(3, 2, 4)
    val target = 6
    nums.sort()

    for (now in 0..(nums.size - 2)) {
        var running = now + 1
        val sum = nums[running] + nums[now]
        while (running < nums.size && sum <= target) {
            if (sum == target) {
                intArrayOf(running, now).print()
            }
            running += 1
        }
    }
    intArrayOf().print()
}

fun IntArray.print() {
    for (i in this) {
        print(i)
    }
}