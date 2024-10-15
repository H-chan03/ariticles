package com.my.articles.DAO;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.dto.CommentDTO;
import com.my.articles.entity.Article;
import com.my.articles.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class CommentDAO {

    @Autowired
    EntityManager em;

    public List<Comment> getAllComment() {
        String sql = "SELECT c FROM Comment c " +
                "ORDER BY c.id DESC";

        return em.createQuery(sql).getResultList();
    }

    public Comment getOneComment(Long id) {
        return em.find(Comment.class, id);
    }

    public void deleteComment(Long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
    }

    public void updateComment(CommentDTO dto) {
        Comment comment = em.find(Comment.class, dto.getId());
        comment.setNickname(dto.getNickname());
        comment.setBody(dto.getBody());
    }

    public void insertComment(Comment comment) {
        em.persist(comment);
    }

}
