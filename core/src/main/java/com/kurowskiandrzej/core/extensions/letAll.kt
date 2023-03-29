package com.kurowskiandrzej.core.extensions

inline fun <T1 : Any, T2 : Any, R : Any> letAll(
    n1: T1?,
    n2: T2?,
    block: (T1, T2) -> R?
): R? {
    return if (
        n1 != null
        && n2 != null
    ) block(n1, n2) else null
}

inline fun <T1 : Any, T2 : Any, T3: Any, R : Any> letAll(
    n1: T1?,
    n2: T2?,
    n3: T3?,
    block: (T1, T2, T3) -> R?
): R? {
    return if (
        n1 != null
        && n2 != null
        && n3 != null
    ) block(n1, n2, n3) else null
}

inline fun <T1 : Any, T2 : Any, T3: Any, T4: Any, R : Any> letAll(
    n1: T1?,
    n2: T2?,
    n3: T3?,
    n4: T4?,
    block: (T1, T2, T3, T4) -> R?
): R? {
    return if (
        n1 != null
        && n2 != null
        && n3 != null
        && n4 != null
    ) block(n1, n2, n3, n4) else null
}