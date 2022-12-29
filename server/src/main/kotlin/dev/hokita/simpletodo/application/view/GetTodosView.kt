package dev.hokita.simpletodo.application.view

data class GetTodosView(
    val todos: List<TodoView>
) {
    data class TodoView(
        val id: Int,
        val title: String,
        val done: Boolean
    )
}
