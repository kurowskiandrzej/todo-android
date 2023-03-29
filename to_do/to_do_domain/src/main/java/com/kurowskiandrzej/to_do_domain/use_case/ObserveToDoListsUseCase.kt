package com.kurowskiandrzej.to_do_domain.use_case

import com.kurowskiandrzej.to_do_domain.model.ToDoList
import com.kurowskiandrzej.to_do_domain.repository.ToDoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveToDoListsUseCase @Inject constructor(
    private val toDoListRepository: ToDoListRepository
) {
    operator fun invoke(): Flow<List<ToDoList>> {
        return toDoListRepository.observeToDoLists()
    }
}