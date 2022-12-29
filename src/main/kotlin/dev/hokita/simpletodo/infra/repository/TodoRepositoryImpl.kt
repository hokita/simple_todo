package dev.hokita.simpletodo.infra.repository

import dev.hokita.simpletodo.domain.entity.Todo
import dev.hokita.simpletodo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import java.time.ZonedDateTime

@Repository
class TodoRepositoryImpl(
    val client: DatabaseClient
) : TodoRepository {
    override fun get(): Flow<Todo> {
        val spec: DatabaseClient.GenericExecuteSpec = client.sql("SELECT * FROM todo;")
        return spec.map { row ->
            val id = row.get("id", Number::class.java)!!
            val title = row.get("title", String::class.java)!!
            val done = row.get("done", Boolean::class.java)!!
            val createAt = row.get("created_at", ZonedDateTime::class.java)!!
            val updatedAt = row.get("updated_at", ZonedDateTime::class.java)!!

            Todo(
                id = id.toInt(),
                title = title,
                done = done,
                createdAt = createAt,
                updatedAt = updatedAt
            )
        }.all().asFlow()
    }
}
