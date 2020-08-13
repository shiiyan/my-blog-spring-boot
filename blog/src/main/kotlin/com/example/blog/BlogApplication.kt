package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {
    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
        val juergen = User("first_login", "Juergen", "Hoeller")
        userRepository.save(juergen)

        val article1 = Article(
            "Spring Framework 5.0 goes GA",
            "Dear Spring community ...",
            "Lorem ipsum dolor sit amet,...",
            juergen
        )

        val article2 = Article(
            "JPA Framework is awesome",
            "Dear JVM community ...",
            "Lorem ipsum dolor sit amet,...",
            juergen
        )

        articleRepository.save(article1)
        articleRepository.save(article2)
    }
}

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
