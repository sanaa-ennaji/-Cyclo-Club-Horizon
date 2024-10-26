# Gestion des compétitions cyclistes

## Description
CCH (Cyclo Club Horizon) est une application qui permet la gestion des courses contre la montre de cyclisme. Chaque coureur concourt individuellement pour réaliser le meilleur temps sur un parcours donné. L'application permet la gestion des coureurs, des compétitions, des inscriptions, des résultats, et des classements.

## Contexte
L'application est destinée à être utilisée par le Cyclo Club Horizon pour organiser et gérer des compétitions cyclistes, avec des fonctionnalités telles que l'ajout de coureurs, la gestion des compétitions, l'inscription aux courses, et la gestion des résultats et classements.

## Fonctionnalités

### Gestion des coureurs
- Ajouter un coureur : nom, prénom, date de naissance, nationalité, équipe
- Modifier/Supprimer un coureur
- Consulter la liste des coureurs avec options de tri (nom, nationalité, équipe)

### Gestion des compétitions
- Créer, modifier, supprimer une compétition : nom, date, lieu, distance
- Consulter la liste des compétitions avec filtres (date, lieu)

### Gestion des inscriptions
- Inscrire ou retirer des coureurs d'une compétition
- Consulter la liste des inscrits

### Gestion des résultats et classements
- Enregistrer les temps des coureurs
- Calcul automatique des classements
- Afficher les classements individuels et cumulés

### Rapports et historique
- Générer des rapports sur les résultats et classements
- Consulter l'historique des compétitions et performances

## Exigences techniques

### Technologie
- **Java**
- **Spring IoC** : gestion des dépendances
- **Hibernate** : persistance des données

### Couche DAO avec Hibernate
- Utiliser `SessionFactory` pour gérer les sessions Hibernate
- Gérer les transactions avec Hibernate et Spring
- Implémenter un DAO générique pour les opérations CRUD

### Configuration Spring
L'application doit inclure les trois types de configurations Spring :
1. **XML** : Pour la persistance (Hibernate, source de données)
2. **Annotations** : Utilisation de `@Component`, `@Service`, `@Repository`, `@Autowired`
3. **Java Configuration** : Utilisation de `@Configuration` pour déclarer des beans

### API REST
- Utiliser **Spring MVC** pour la couche web
- Utilisation de `@Configuration` pour la configuration
- Utiliser `ResponseEntity` pour gérer les réponses HTTP
- DTOs pour la communication avec la couche service
- Pagination optionnelle

### Tests unitaires et TDD
- Tests unitaires avec **JUnit** et **Mockito**
- Développement piloté par les tests (TDD)

## Endpoints

### 1. Team
- `GET /api/v1/teams`
- `GET /api/v1/teams/{id}`
- `POST /api/v1/teams`
- `PUT /api/v1/teams/{id}`
- `DELETE /api/v1/teams/{id}`

### 2. Cyclist
- `GET /api/v1/cyclists`
- `GET /api/v1/cyclists/{id}`
- `POST /api/v1/cyclists`
- `PUT /api/v1/cyclists/{id}`
- `DELETE /api/v1/cyclists/{id}`

### 3. Competition
- `GET /api/v1/competitions`
- `GET /api/v1/competitions/{id}`
- `POST /api/v1/competitions`
- `PUT /api/v1/competitions/{id}`
- `DELETE /api/v1/competitions/{id}`

### 4. Stage
- `GET /api/v1/stages`
- `GET /api/v1/stages/{id}`
- `POST /api/v1/stages`
- `PUT /api/v1/stages/{id}`
- `DELETE /api/v1/stages/{id}`

### 5. GeneralResult
- `GET /api/v1/general-results`
- `GET /api/v1/general-results/{competitionId}/{cyclistId}`
- `POST /api/v1/general-results`
- `DELETE /api/v1/general-results/{competitionId}/{cyclistId}`

### 6. StageResult
- `GET /api/v1/stage-results`
- `GET /api/v1/stage-results/{stageId}/{cyclistId}`
- `POST /api/v1/stage-results`
- `DELETE /api/v1/stage-results/{stageId}/{cyclistId}`

## Technologies et outils
- **JPA**, **Hibernate**, **Spring IoC**, **JUnit**, **Mockito**
- **Spring MVC**, **Tomcat**, **ModelMapper**, **MapStruct**
- **Postman**, **DTO**

```