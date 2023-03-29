package com.kurowskiandrzej.to_do_data.mapper

import com.kurowskiandrzej.app_database.entity.to_do_list.ToDoListEntity
import com.kurowskiandrzej.to_do_data.remote.dto.ToDoListDto

fun ToDoListDto.toToDoListEntity(): ToDoListEntity =
    ToDoListEntity(
        id = id,
        name = name,
        createdAt = createdAt
    )

fun List<ToDoListDto>.toToDoListEntityList(): List<ToDoListEntity> =
    this.map { it.toToDoListEntity() }