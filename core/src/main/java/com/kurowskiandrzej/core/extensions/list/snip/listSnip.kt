package app.eclectus.core.extensions.list.snip

fun <T> List<T>.snip(from: Int = 0, to: Int = 0, step: Int = 1): List<T> {

    val result = this.subList(
        fromIndex = if (from >= 0) from else this.size + from,
        toIndex = if (to > 0) to + 1 else if (to == 0) this.size else this.size + to + 1
    )

    return if (step > 1) {
        listOf()
    } else if (step < 0) {
        listOf()
    } else {
        result
    }
}

fun <T> List<T>.snip(at: Int): T {
    return if (at >= 0) this[at]
    else this[this.size + at]
}