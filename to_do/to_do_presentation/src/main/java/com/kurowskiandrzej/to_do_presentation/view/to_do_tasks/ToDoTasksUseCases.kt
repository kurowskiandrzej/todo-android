package com.kurowskiandrzej.to_do_presentation.view.to_do_tasks

import com.kurowskiandrzej.to_do_domain.use_case.ObserveToDoTasksUseCase
import javax.inject.Inject

data class ToDoTasksUseCases @Inject constructor(
    val observeToDoTasks: ObserveToDoTasksUseCase
)