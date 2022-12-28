package dev.hokita.simpletodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpletodoApplication

fun main(args: Array<String>) {
	runApplication<SimpletodoApplication>(*args)
}
