package com.audiens.blog.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.audiens.blog.model.Article;
import com.audiens.blog.model.Commentaire;
import com.audiens.blog.model.Utilisateur;

@Component
public class BlogDaoImpl implements BlogDao {
	
	@Autowired UtilisateurRepository utilisateurRepository;
	@Autowired ArticleRepository articleRepository;
	@Autowired CommentaireRepository commentaireRepository;

	@Override
	public Long add(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
		if(utilisateur.isPresent())
	   	   return utilisateur.get();
		else
			return null;
	}

	@Override
	public Utilisateur getUtilisateur(String email) {
		return utilisateurRepository.findByEmail(email);
	}
	
	@Override
	public Utilisateur getUtilisateur(String login, String password) {
		Utilisateur send = utilisateurRepository.findByEmail(login);
		if(send.getMdp().equals(password)) {
			return utilisateurRepository.findByEmail(login);
		} else {
			return null;
		}
	}
	
	@Override
	public Utilisateur getUtilisateur(Article article) {
		Optional<Utilisateur> optional= utilisateurRepository.findById(article.getUtilisateur().getId());
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
		
	@Override
	public Long update(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public Long del(Utilisateur utilisateur) {
		utilisateurRepository.delete(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public Long add(Article article) {
		System.out.println("User : " + article.getUtilisateur());
		articleRepository.save(article);
		return article.getId();
	}

	@Override
	public Article getArticle(Long id) {
		Optional<Article> article = articleRepository.findById(id);
		return article.get();
	}
	
	@Override
	public List<Article> getArticleByAuthor(Utilisateur utilisateur) {
		List<Article> articles = articleRepository.findByUtilisateur(utilisateur);
		return articles;
	}

	@Override
	public List<Article> lastArticle(Long nombre) {
		List<Article> articles = articleRepository.findAllByOrderByCreeleDesc();
		if(articles.size() <= nombre)
		  return articles;
		else {
			List<Article> liste = articles.subList(0,nombre.intValue());
			return liste;
		}
	}
	
	@Override
	public Long add(Commentaire commentaire) {
		commentaireRepository.save(commentaire);
		return commentaire.getId();
	}

	@Override
	public Long add(Commentaire commentaire, Article article, Utilisateur utilisateur) {
		commentaire.setArticle(article);
		commentaire.setUtilisateur(utilisateur);
		commentaireRepository.save(commentaire);
		return commentaire.getId();
	}

	@Override
	public List<Commentaire> getCommentaireByArticle(Article article) {
		return article.getCommentaires();
	}

	@Override
	public List<Utilisateur> findAllUtilisateur() {
		return utilisateurRepository.findAll();
	}

	@Override
	public List<Article> findAllArticle() {
		return articleRepository.findAll();
	}

	@Override
	public Long update(Article article) {
		articleRepository.save(article);
		return article.getId();
	}

	@Override
	public void del(Article article) {
		articleRepository.delete(article);
	}

	@Override
	public Long update(Commentaire commentaire) {
		commentaireRepository.save(commentaire);
		return commentaire.getId();
	}

	@Override
	public void del(Commentaire commentaire) {
		commentaireRepository.delete(commentaire);
		
	}


	
}
