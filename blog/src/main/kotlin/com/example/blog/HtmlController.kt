package com.example.blog

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = repository.findAllByOrderByAddedAtDesc()
        return "blog"
    }

//    @GetMapping("/article/{id}")
//    fun article(@PathVariable id: Long, model: Model): String {
//        val article = repository.findById(id).orElseThrow { IllegalArgumentException("Wrong article id provided") }
//
//        model["title"] = article.title
//        model["article"] = article
//
//        return "article"
//    }
}
