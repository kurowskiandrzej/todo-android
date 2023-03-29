package com.kurowskiandrzej.core.extensions

fun <T> MutableSet<T>.alter(element: T) {
    if (this.contains(element)) {
        this.remove(element)
    } else {
        this.add(element)
    }
}

fun <T> Set<T>.altered(element: T): Set<T> {
    val alteredSet = this.toMutableSet()
    alteredSet.alter(element)
    return alteredSet
}