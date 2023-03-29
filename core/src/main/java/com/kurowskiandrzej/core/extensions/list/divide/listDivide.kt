package app.eclectus.core.extensions.list.divide

fun <T> List<T>.divide(
    vararg subListLengths: Int,
    includeRemaining: Boolean = false
): List<List<T>> {
    val result = mutableListOf<List<T>>()

    subListLengths.forEach { substringLength ->
        result.add(
            if (result.isEmpty()) {
                this.subList(
                    fromIndex = 0,
                    toIndex = substringLength
                )
            } else {
                val sumOfAddedElements = result.sumOf { it.size }
                this.subList(
                    fromIndex = sumOfAddedElements,
                    toIndex = sumOfAddedElements + substringLength
                )
            }
        )
    }

    val sumOfAddedElements = result.sumOf { it.size }
    if (includeRemaining && sumOfAddedElements < this.size) {
        result.add(
            this.subList(sumOfAddedElements, this.size)
        )
    }

    return result
}

fun <T> List<T>.divideInto(
    subListLength: Int,
    includeRemaining: Boolean = false
): List<List<T>> {

    val array = mutableListOf<Int>()

    repeat(times = this.size / subListLength) {
        array.add(subListLength)
    }

    return this.divide(*array.toIntArray(), includeRemaining = includeRemaining)
}