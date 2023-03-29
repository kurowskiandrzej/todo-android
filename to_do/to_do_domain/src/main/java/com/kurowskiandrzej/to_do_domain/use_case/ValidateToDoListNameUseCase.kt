package com.kurowskiandrzej.to_do_domain.use_case

import javax.inject.Inject

class ValidateToDoListNameUseCase @Inject constructor() {
    operator fun invoke(toDoListName: String): Boolean {
        return toDoListName.isNotBlank()
                && toDoListName.length <= MAX_TO_DO_LIST_NAME_LENGTH
    }

    companion object {
        private const val MAX_TO_DO_LIST_NAME_LENGTH = 200
    }
}