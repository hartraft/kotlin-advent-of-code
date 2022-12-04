fun main() {
    fun part1(input: List<String>): Int {
        var part1Answer = 0
        input.zipWithNext { current: String, next: String -> if (next.toInt() > current.toInt()) part1Answer++ }
        return part1Answer
    }

    fun part2(input: List<String>): Int {
        val elves = input().split("\n\n").map { elf -> elf.split("\n").sumOf { it.toInt() } }.sortedByDescending { it }.take(3)

        //println("Total ${elves.sumOf { it }}")
	val part2Answer = elves.sumOf { it }
        return part2Answer
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 0)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
