package com.my.articles.controller;

import com.my.articles.DAO.ArticleDAO;
import com.my.articles.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    public ArticleService articleService;

    @GetMapping("")
    public String showAllArticles(Model model) {
        model.addAttribute("main", "main");
        model.addAttribute("lists", articleService.findAll());
        return "/articles/show_all";
    }

    @GetMapping("new")
    public String newArticle() {

        return "/articles/new";
    }

    @PostMapping("create")
    public String createArticle(@Valid @ModelAttribute("dao") ArticleDAO dao) {

        articleService.saveArticle(dao);
        return "redirect:articles";
    }

    @GetMapping("{id}")
    public String showOneArticle(){

        return "/articles/show";
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle() {

        return "/articles/update";
    }

    @PostMapping("update")
    public String updateArticle() {

        return "redirect:articles";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle() {

        return "redirect:articles";
    }
}
