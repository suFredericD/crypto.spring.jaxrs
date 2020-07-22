package com.audiens.blog.dao;

import java.util.List;

import com.audiens.blog.model.Article;
import com.audiens.blog.model.Commentaire;
import com.audiens.blog.model.Utilisateur;

public interface BlogDao {
	// Les utilisateurs
	public Long add(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(Long id);
	public Utilisateur getUtilisateur(String email);
	public Long update(Utilisateur utilisateur);
	public void del(Utilisateur utilisateur);
		
	// Les articles
	public Long add(Article article);
	public Article getArticle(Long id);
	public List<Article> getArticleByAuthor(Utilisateur utilisateur);
	
	// Les commentaires
	public Commentaire add (Commentaire commentaire);
	public Long add (Commentaire commentaire, Article article, Utilisateur utilisateur);
	public List<Commentaire> getCommentaireByArticle(Article article);
	
}
