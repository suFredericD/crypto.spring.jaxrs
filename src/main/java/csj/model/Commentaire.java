package com.audiens.blog.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
@JsonIgnoreProperties(value={"article","utilisateur"},allowSetters = true)
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String contenu;

	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp creele;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idauteur")
	private Utilisateur utilisateur;

	public Commentaire() {
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

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}