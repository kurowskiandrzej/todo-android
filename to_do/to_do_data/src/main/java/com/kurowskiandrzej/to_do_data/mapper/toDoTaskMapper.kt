package com.kurowskiandrzej.to_do_data.mapper

import com.kurowskiandrzej.app_database.entity.to_do_task.ToDoTaskEntity
import com.kurowskiandrzej.to_do_data.remote.dto.ToDoTaskDto

fun ToDoTaskDto.toToDoTaskEntity(): ToDoTaskEntity =
    ToDoTaskEntity(
        id = id,
        listId = listId,
        value = value,
        isCompleted = isCompleted,
        createdAt = createdAt,
        completedOn = completedOn
    )

fun List<ToDoTaskDto>.toToDoTaskEntityList(): List<ToDoTaskEntity> =
    this.map { it.toToDoTaskEntity() }