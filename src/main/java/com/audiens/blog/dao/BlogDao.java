package com.audiens.blog.dao;

import java.util.List;

import com.audiens.blog.model.Article;
import com.audiens.blog.model.Commentaire;
import com.audiens.blog.model.Utilisateur;

public interface BlogDao {
	// Les utilisateurs
	public List<Utilisateur> findAllUtilisateur();
	public Long add(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(Long id);
	public Utilisateur getUtilisateur(String email);
	public Long update(Utilisateur utilisateur);
	public void del(Utilisateur utilisateur);
		
	// Les articles
	public List<Article> findAllArticle();
	public List<Article> lastArticle(Long nombre);
	public Long add(Article article);
	public Long update(Article article);
	public Article getArticle(Long id);
	public List<Article> getArticleByAuthor(Utilisateur utilisateur);
	public void del(Article article);
	
	// Les commentaires
	public Long add (Commentaire commentaire);
	public Long add (Commentaire commentaire, Article article, Utilisateur utilisateur);
	public List<Commentaire> getCommentaireByArticle(Article article);
	public Long update(Commentaire commentaire);
	public void del(Commentaire commentaire);
	
}
