fun main() {
    fun part1(input: List<Int>, position: Int = 2): Int? {
        var fuelUsed = 0
        val mutate = input.map {
            if (it < position) { val movement = position - it; fuelUsed+= movement; position
            } else if (it > position) { val movement = it - position; fuelUsed+= movement; position
            } else { position }
        }
        return if (mutate.all { it == position }) fuelUsed else null
    }

    fun part2(input: List<Int>, position: Int = 2): Int? {
        var fuelUsed = 0
        val mutate = input.map {
            if (it < position) { fuelUsed+= incrementValues(it, position); position
            } else if (it > position) { fuelUsed+= incrementValues(it, position); position
            } else { position }
        }
        return if (mutate.all { it == position }) fuelUsed else null
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test").first().split(",").map { it.toInt() }
    val map = hashMapOf<Int, Int>()
    for (i in 1..10) if (part1(testInput, i) != null) map[i] = part1(testInput, i)!!

    val minOf = map.minByOrNull { it.value }
    println("Test ${minOf?.key}")

    val input = readInput("Day07").first().split(",").map { it.toInt() }
    map.clear()
    for (i in 1..1000) if (part1(input, i) != null) map[i] = part1(input, i)!!

    println("Part1 ${map.minByOrNull { it.value }?.value}")

    val mapPart2 = hashMapOf<Int, Int>()
    for (i in 1..1000) if (part2(input, i) != null) mapPart2[i] = part2(input, i)!!
    println("Part2 ${mapPart2.minByOrNull { it.value }?.value}")
}

fun incrementValues(source: Int, target: Int = 5): Int {
    var returnValue = 0
    return if (source > target) {
        (source downTo target).forEachIndexed { index, i ->
            if (i != target) returnValue += index + 1
        }
        returnValue
    } else if (source < target) {
        (source until target).forEachIndexed { index, i ->
            if (i != target) returnValue += index + 1
        }
        returnValue
    } else {
        returnValue
    }
}
