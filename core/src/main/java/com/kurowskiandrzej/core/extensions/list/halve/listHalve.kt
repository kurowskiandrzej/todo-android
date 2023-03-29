package app.eclectus.core.extensions.list.halve

import app.eclectus.core.extensions.list.snip.snip

fun <T> List<T>.halve(): Pair<List<T>, List<T>> {
    return Pair(
        this.snip(from = 0, to = this.size / 2 - 1),
        this.snip(from = this.size / 2, to = -1)
    )
}

fun <T> List<T>.halveAndZip(): List<Pair<T, T>> {
    val halves = this.halve()

    return halves.first.zip(halves.second)
}

fun <T> List<T>.zipConsecutively(): List<Pair<T, T>> {
    val result = mutableListOf<Pair<T, T>>()

    var firstIndex = 0
    var secondIndex = 1

    while(secondIndex < this.lastIndex) {
        result.add(Pair(this[firstIndex], this[secondIndex]))

        firstIndex += 2
        secondIndex += 2
    }

    return result
}