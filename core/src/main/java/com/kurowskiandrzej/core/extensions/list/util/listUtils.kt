package app.eclectus.core.extensions.list.util

fun <T> List<T>.second(): T {
    return this[1]
}

fun <T> List<T>.secondToLast(): T {
    return this[this.size - 2]
}

fun <T> List<T>.third(): T {
    return this[2]
}

fun <T> List<T>.fourth(): T {
    return this[3]
}

fun <T> List<T>.fifth(): T {
    return this[4]
}