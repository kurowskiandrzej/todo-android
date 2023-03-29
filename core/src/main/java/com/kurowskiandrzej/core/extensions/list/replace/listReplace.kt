package app.eclectus.core.extensions.list.replace

/**
 * @return copy of current list with replaced element at provided [index].
 * If [index] is out of bounds, [item] is added to the end of the list
 * */
fun <T> List<T>.replacedAt(index: Int, item: T): List<T> {
    val update = this.toMutableList()

    if (index >= this.size) update.add(item) // todo throw exception when index too high
    else update[index] = item

    return update
}