package csj.dao;

import java.util.List;

import csj.model.*;

public interface CryptoDao {
	// Les personnes
	public List<People> findAllPeople();
	public People getPeople(Long id);
	
	// Les monnaies
	public List<Currency> findAllCurrencies();
	public Currency getCurrency(Long id);
	public List<Currency> getCurrenciesByType(Long id);
	
	// Les types de monnaies
	public CurrencyType getCurrencyType(Long id);
	
	//	public Long add(Utilisateur utilisateur);
//	public Utilisateur getUtilisateur(Long id);
//	public Utilisateur getUtilisateur(String email);
//	public Utilisateur getUtilisateur(String login, String password);
//	public Long update(Utilisateur utilisateur);
//	public Long del(Utilisateur utilisateur);
		
//	// Les articles
//	public List<Article> findAllArticle();
//	public List<Article> lastArticle(Long nombre);
//	public Long add(Article article);
//	public Long update(Article article);
//	public Article getArticle(Long id);
//	public Utilisateur getUtilisateur(Article article);
//	public List<Article> getArticleByAuthor(Utilisateur utilisateur);
//	public void del(Article article);
//	
//	// Les commentaires
//	public Long add (Commentaire commentaire);
//	public Long add (Commentaire commentaire, Article article, Utilisateur utilisateur);
//	public List<Commentaire> getCommentaireByArticle(Article article);
//	public Long update(Commentaire commentaire);
//	public void del(Commentaire commentaire);
	
}
