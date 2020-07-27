package com.audiens.blog.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
}) 


@TableGenerator(name="utilisateur", table="hibernate_sequences",initialValue=0, allocationSize=1)
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="utilisateur")
	private Long id;

	private Timestamp creele;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	private String email;

	private String login;

	private String mdp;

	private String nom;

	private String prenom;

	private String telephone;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="utilisateur")
	private List<Article> articles;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="utilisateur")
	private List<Commentaire> commentaires;

	public Utilisateur() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreele() {
		return this.creele;
	}

	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setUtilisateur(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setUtilisateur(null);

		return article;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setUtilisateur(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setUtilisateur(null);

		return commentaire;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", creele=" + creele + ", datenaissance=" + datenaissance + ", email=" + email
				+ ", login=" + login + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
				+ telephone + "]";
	}

	
}