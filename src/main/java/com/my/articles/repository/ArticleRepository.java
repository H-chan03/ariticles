package com.my.articles.repository;

import com.my.articles.DAO.ArticleDAO;
import com.my.articles.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {




    @Query(value = "SELECT * FROM article ORDER BY id", nativeQuery = true)
    List<Article> showAllArticle();

    static Map<Long, Article> store = new HashMap<>();


    @Override
    default Article save(Article article) {
        store.put(article.getId(), article);
        return article;
    }


    default Optional<Article> findByArticleId(Long id) {
        return store.values().stream()
                .filter(x -> x.getId().equals(id))
                .findAny();
    }


    default Optional<Article> findByTitle(String title) {
        return store.values().stream()
                .filter(x->x.getTitle().equals(title))
                .findAny();
    }

    @Override
    default List<Article> findAll() {
        return new ArrayList<>(store.values());
    }


}
