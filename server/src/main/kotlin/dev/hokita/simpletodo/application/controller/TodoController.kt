package dev.hokita.simpletodo.application.controller

import dev.hokita.simpletodo.application.view.GetTodosView
import dev.hokita.simpletodo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(
    val repository: TodoRepository
) {
    @GetMapping("/todos")
    suspend fun getTodos(): GetTodosView? {
        val todos = repository.get()
        return GetTodosView(
            todos.map { todo ->
                GetTodosView.TodoView(
                    id = todo.id,
                    title = todo.title,
                    done = todo.done
                )
            }.toList()
        )
    }
}
