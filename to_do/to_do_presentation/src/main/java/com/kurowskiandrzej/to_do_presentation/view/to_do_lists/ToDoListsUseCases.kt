package com.kurowskiandrzej.to_do_presentation.view.to_do_lists

import com.kurowskiandrzej.to_do_domain.use_case.ObserveToDoListsUseCase
import com.kurowskiandrzej.to_do_domain.use_case.PostToDoListUseCase
import com.kurowskiandrzej.to_do_domain.use_case.ValidateToDoListNameUseCase
import javax.inject.Inject

data class ToDoListsUseCases @Inject constructor(
    val observeToDoLists: ObserveToDoListsUseCase,
    val validateToDoListName: ValidateToDoListNameUseCase,
    val postToDoList: PostToDoListUseCase
)