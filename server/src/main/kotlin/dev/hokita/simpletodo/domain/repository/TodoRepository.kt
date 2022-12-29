package dev.hokita.simpletodo.domain.repository

import dev.hokita.simpletodo.domain.entity.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun get(): Flow<Todo>
}
