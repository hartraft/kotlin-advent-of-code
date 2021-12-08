fun main() {
    fun part1(input: String): Int {
        return readInput(input).map { it.split("|").last().trim().split(" ").count { signal -> signal.length in listOf(2, 4, 3, 7) }  }.reduce { acc, element -> acc + element }
    }

    fun part2(input: List<Int>): Int? {
        return null
    }

    // test if implementation meets criteria from the description, like:
    println("Test ${part1("Day08_test")}")
    println("Part1 ${part1("Day08")}")
}

