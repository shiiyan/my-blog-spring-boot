package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) =
        ApplicationRunner {
            val juergen = User("first_login", "Juergen", "Hoeller")
            userRepository.save(juergen)

            val article1 = Article(
                title = "Spring Framework 5.0 goes GA",
                headline = "Dear Spring community ...",
                content = "Lorem ipsum dolor sit amet,...",
                author = juergen
            )

            val article2 = Article(
                title = "JPA Framework is awesome",
                headline = "Dear JVM community ...",
                content = "Lorem ipsum dolor sit amet,...",
                author = juergen
            )

            articleRepository.save(article1)
            articleRepository.save(article2)
        }
}
