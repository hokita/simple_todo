package dev.hokita.simpletodo.domain.entity

import java.time.ZonedDateTime

data class Todos(
    val todo: List<Todo>
) : List<Todo> by todo

data class Todo(
    val id: Int,
    val title: String,
    val done: Boolean,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime
)
