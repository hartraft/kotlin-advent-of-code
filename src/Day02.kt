fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        input.forEach {
            when (it.split(" ").first().trim()) {
                "forward" -> x+= it.split(" ")[1].trim().toInt()
                "down" -> y+= it.split(" ")[1].trim().toInt()
                "up" -> y-= it.split(" ")[1].trim().toInt()
            }
        }
        return x*y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0

        input.forEach {
            when (it.split(" ").first().trim()) {
                "forward" -> {
                    val targetX = it.split(" ")[1].trim().toInt()
                    x+= targetX
                    y+=aim*targetX
                }
                "down" -> {
                    val targetY = it.split(" ")[1].trim().toInt()
                    aim+= targetY
                }
                "up" -> {
                    val targetY = it.split(" ")[1].trim().toInt()
                    aim-= targetY
                }
            }
        }
        return x*y
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
