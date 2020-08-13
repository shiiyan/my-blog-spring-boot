package com.example.blog

import blog.Article
import blog.ArticleRepository
import blog.User
import blog.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
        val author1 = User("first", "F", "L")
        userRepository.save(author1)

        val article1 = Article(
            "タイトル１",
            "一つ目の文章です。",
            "サンプルコンテントサンプルコンテント",
            author1,
            1
        )

        articleRepository.save(article1)
    }
}

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
