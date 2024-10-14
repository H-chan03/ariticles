package com.my.articles.DAO;


import com.my.articles.entity.Article;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDAO {


    private Long id;
    private String title;
    private String content;

    //Entity -> DAO

    public static ArticleDAO fromEntity(Article article) {
        return new ArticleDAO(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }

    //DAO -> entity
    public static Article fromDAO(ArticleDAO dao) {
        return new Article(
                dao.getId(),
                dao.getTitle(),
                dao.getContent()
        );
    }


}
