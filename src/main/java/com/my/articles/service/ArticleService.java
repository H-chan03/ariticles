package com.my.articles.service;

import com.my.articles.DAO.ArticleDAO;
import com.my.articles.entity.Article;
import com.my.articles.repository.ArticleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticleDAO> findAll() {
        return articleRepository.showAllArticle()
                .stream()
                .map(entity -> ArticleDAO.fromEntity(entity))
                .toList();
    }


    public void saveArticle(ArticleDAO dao) {
        articleRepository.save(ArticleDAO.fromDAO(dao));
    }
}
