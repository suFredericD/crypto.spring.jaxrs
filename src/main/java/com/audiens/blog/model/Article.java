package com.audiens.blog.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
@JsonIgnoreProperties(value={"utilisateur"},allowSetters = true)
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id        
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	private String contenu;

	@Column(updatable = false)
	@CreationTimestamp 
	private Timestamp creele;

	private String titre;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idauteur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="article")
	private List<Commentaire> commentaires;

	public Article() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Timestamp getCreele() {
		return this.creele;
	}

	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setArticle(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setArticle(null);

		return commentaire;
	}

}