package com.example.blog

import blog.ArticleRepository
import blog.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {
	@Bean
	fun databaseInitializer(userReposityory: UserRepository, articleRepository: ArticleRepository) {}
}




fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}
