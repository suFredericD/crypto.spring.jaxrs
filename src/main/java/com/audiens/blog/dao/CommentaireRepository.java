package com.audiens.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audiens.blog.model.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
