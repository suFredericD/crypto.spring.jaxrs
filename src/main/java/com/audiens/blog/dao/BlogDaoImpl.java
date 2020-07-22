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

	@Override
	public Long add(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
		return utilisateur.get();
	}

	@Override
	public Utilisateur getUtilisateur(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	@Override
	public Long update(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur.getId();
	}

	@Override
	public void del(Utilisateur utilisateur) {
		utilisateurRepository.delete(utilisateur);
	}

	@Override
	public Long add(Article article) {
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
	public Commentaire add(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long add(Commentaire commentaire, Article article, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commentaire> getCommentaireByArticle(Article article) {
		// TODO Auto-generated method stub
		return null;
	}


}
