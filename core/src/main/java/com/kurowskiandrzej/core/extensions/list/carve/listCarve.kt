package app.eclectus.core.extensions.list.carve

/**
 * @return new list without an item at provided index
 *
 * @param at index of an item that will be removed from the list
 * */
fun <T> List<T>.carved(at: Int): List<T> {
    val update = this.toMutableList()
    update.removeAt(at)
    return update
}

fun <T> List<T>.carved(from: Int, to: Int): List<T> {
    return listOf()
}