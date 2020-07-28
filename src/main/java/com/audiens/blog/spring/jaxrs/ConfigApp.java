package com.audiens.blog.spring.jaxrs;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.audiens.blog.dao.BlogDao;
import com.audiens.blog.dao.BlogDaoImpl;

@Configuration
public class ConfigApp {

	/**
	 * Une datasource pour la connexion à la base de données.
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:postgresql://127.0.0.1:5432/drivephil");
		dataSourceBuilder.username("driveuser");
		dataSourceBuilder.password("secret");
		return dataSourceBuilder.build();
	}

	/**
	 * Configuration de l'entity manager factory
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// Définir s'il faut générer DDL après l'initialisation de EntityManagerFactory, 
		// création / mise à jour  pour toutes les tables.
		vendorAdapter.setGenerateDdl(true);
		// C'est le moyen le plus puissant de configurer une entité JPA EntityManagerFactory partagée 
		// dans un contexte d'application Spring. 
		// L'EntityManagerFactory peut ensuite être transmis aux DAO basés sur JPA via l'injection de dépendances.
		// Le passage à une recherche JNDI ou à une définition LocalEntityManagerFactoryBean n'est qu'un
		// question de configuration!
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// Spécifie l'implémentation JpaVendorAdapter pour le fournisseur JPA souhaité, le cas échéant. 
		// Cela initialisera les valeurs par défaut appropriées pour le fournisseur donné, 
		// telles que la classe de fournisseur de persistance et JpaDialect, sauf s'il est surchargé localement 
		// dans ce FactoryBean.
		factory.setJpaVendorAdapter(vendorAdapter);
		// Définit s'il faut analyser le ClassPath standard des fichiers jar contenant des marqueurs de persistence.xml. 
		// En cas de ressort analyse, aucun persistence.xml n'est nécessaire; 
		// il vous suffit de spécifier les packages de base à rechercher dans le paramètre.
		factory.setPackagesToScan("com.audiens.blog.model");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	/**
	 * Gestionnaire des transactions
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	} 
	
	@Bean BlogDao blogDao() {
		return new BlogDaoImpl();
	}
	
}
