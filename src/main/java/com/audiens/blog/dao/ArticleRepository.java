package com.audiens.blog.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.audiens.blog.model.Article;
import com.audiens.blog.model.Utilisateur;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
   List<Article> findByUtilisateur(Utilisateur utilisateur);
}
