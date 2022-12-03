fun main() {
    fun part1(input: String, lookupMap: Map<String, String>, repeat: Int): Int {
        if (repeat == 0) {
            val min = input.groupBy { it }.minByOrNull { it.value.size }?.value?.size ?: 0
            val max = input.groupBy { it }.maxByOrNull { it.value.size }?.value?.size ?: 0
            return max - min
        }
        val trans = input.windowed(2).map { it.first().plus(lookupMap[it]?:"").plus(it.last()) }
        val subList = trans.subList(1, trans.size).joinToString("") { it.substring(1, 3) }
        val final = trans.first().plus(subList)
        return part1(final, lookupMap, repeat-1)
    }

    fun part2(input: List<Int>): Int? {
        return null
    }

    // test if implementation meets criteria from the description, like:
    val (inputTest, lookupMapTest) = readMap("Day14_test")
    check(part1(inputTest, lookupMapTest, 10) == 1588)
    val (input1, lookupMap1) = readMap("Day14")
    println("${part1(input1, lookupMap1, 10)}")

}

private fun readMap(polymerInput: String): Pair<String, HashMap<String, String>> {
    val inputLines = readInput(polymerInput)
    val input = inputLines.first()
    val lookupMap = hashMapOf<String, String>()
    inputLines.forEachIndexed { index, string ->
        if (index <= 1) return@forEachIndexed
        val lines = string.split("->")
        val pattern = lines.first().trim()
        val substitution = lines.last().trim()
        lookupMap[pattern] = substitution
    }
    return Pair(input, lookupMap)
}
