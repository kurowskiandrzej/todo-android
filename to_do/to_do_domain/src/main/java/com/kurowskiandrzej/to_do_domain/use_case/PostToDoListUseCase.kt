package com.kurowskiandrzej.to_do_domain.use_case

import com.kurowskiandrzej.to_do_domain.repository.ToDoListRepository
import javax.inject.Inject

class PostToDoListUseCase @Inject constructor(
    private val toDoListRepository: ToDoListRepository
) {
    suspend operator fun invoke(toDoListName: String): Result<Unit> {
        return toDoListRepository.postToDoList(
            toDoListName = toDoListName
        )
    }
}