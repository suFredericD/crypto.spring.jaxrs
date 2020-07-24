## blog.spring.jaxrs

### Step1 : 
#### Création du projet avec start.spring.io
* spring-boot-starter-data-jpa
* spring-boot-starter-jersey
* spring-boot-starter-web
* postgresql
* slf4j-api 

#### Ajout des packages model et dao

#### Configuration SLF4J    

### Step2 : 
           
#### Création du contrôleur UtilisateurController

* liste des utilisateurs
* opérations CRUD sur les utilisateurs et les articles.
* Expression régulière sur les RequestMapping : @RequestMapping(path="/{email:[A-z0-9]+.[A-z0-9]+@[A-z0-9]+.[A-z0-9]{2,6}}", method = RequestMethod.GET)

#### Création du contrôleur ArticleController

* liste des articles
* opérations CRUD sur les articles.


 