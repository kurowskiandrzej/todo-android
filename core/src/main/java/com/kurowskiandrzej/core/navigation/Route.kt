package com.kurowskiandrzej.core.navigation

object Route {
    const val TO_DO_LIST_ID_KEY = "to_do_list_id"

    const val TODO_NAV = "to_do_nav"
    const val TODO_LISTS = "to_do_lists"
    const val TODO_TASKS = "to_do_tasks"

    const val LOGIN = "login"
    const val REGISTER = "register"
    const val AUTH_EXIT = TODO_NAV

    fun build(
        route: String,
        vararg args: Any
    ): String {
        var result = route

        args.forEach { argument ->
            result += "/$argument"
        }

        return result
    }
}