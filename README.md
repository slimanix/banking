# Banking Service

Ce projet est une application Java/Spring Boot qui simule les fonctionnalités de base d'un système bancaire : dépôt, retrait et impression de relevé bancaire. Il s'agit d'un exercice technique respectant les bonnes pratiques d'architecture (entities, services, controllers, DTO, gestion des exceptions, etc.).

## Fonctionnalités principales
- Déposer de l'argent sur un compte
- Retirer de l'argent d'un compte
- Afficher le relevé bancaire d'un compte
- Gestion des erreurs (montant négatif, fonds insuffisants, etc.)
- Stockage en mémoire (aucune base de données requise)

## Structure du projet
```
src/main/java/com/skypay/banking/
  controllers/         // Endpoints REST
  dto/                 // Objets de transfert (requêtes/réponses)
  entities/            // Modèles métier (Compte, Transaction)
  exceptions/          // Gestion des exceptions
  models/              // Interfaces métier
  services/            // Logique métier
```

## Prérequis
- Java 17 ou supérieur
- Maven

## Lancer le projet
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/slimanix/banking.git
   cd banking
   ```
2. Compiler et lancer l'application :
   ```bash
   mvn spring-boot:run
   ```
3. L'application démarre sur `http://localhost:8080`

## Documentation des API

### 1. Déposer de l'argent
- **Méthode** : POST
- **URL** : `/accounts/{id}/deposit`
- **Body (JSON)** :
  ```json
  {
    "amount": 1000
  }
  ```
- **Réponse** :
  ```json
  {
    "message": "Deposit successful"
  }
  ```

### 2. Retirer de l'argent
- **Méthode** : POST
- **URL** : `/accounts/{id}/withdraw`
- **Body (JSON)** :
  ```json
  {
    "amount": 500
  }
  ```
- **Réponse** :
  ```json
  {
    "message": "Withdraw successful"
  }
  ```

### 3. Afficher le relevé bancaire
- **Méthode** : GET
- **URL** : `/accounts/{id}/statement`
- **Réponse** :
  ```json
  {
    "lines": [
      "Date       || Amount || Balance",
      "14/01/2012 || -500 || 2500",
      "13/01/2012 || 2000 || 3000",
      "10/01/2012 || 1000 || 1000"
    ]
  }
  ```

## Remarques
- Les comptes sont créés automatiquement lors de la première opération.
- Toutes les données sont perdues à l'arrêt de l'application (stockage en mémoire).
- Les erreurs sont retournées avec des messages explicites et des codes HTTP appropriés.

## Auteur
- ELIDRISSI-SLIMANI ABDERRAHMANE