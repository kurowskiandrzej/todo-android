package com.kurowskiandrzej.to_do_domain.use_case

import com.kurowskiandrzej.to_do_domain.repository.ToDoListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(
    private val toToDoListRepository: ToDoListRepository
) {
    suspend operator fun invoke(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        token: String
    ): Result<Unit> {
        return toToDoListRepository.fetchData(
            dispatcher = dispatcher,
            token = token
        )
    }
}