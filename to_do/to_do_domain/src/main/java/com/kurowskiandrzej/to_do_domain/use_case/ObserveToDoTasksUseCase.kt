package com.kurowskiandrzej.to_do_domain.use_case

import com.kurowskiandrzej.to_do_domain.model.ToDoTask
import com.kurowskiandrzej.to_do_domain.repository.ToDoTaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveToDoTasksUseCase @Inject constructor(
    private val toDoTaskRepository: ToDoTaskRepository
) {
    operator fun invoke(listId: Long): Flow<List<ToDoTask>> {
        return toDoTaskRepository.observeTasksByListId(listId)
    }
}