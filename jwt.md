## JSON WEB TOKEN

Est un jeton d'accès permettant un échane sécurisé de données entre 2 parties

  
Structure JWT :  
un JWT signé se compose en 3 parties :  
HEADER.PAYLOAD.SIGNATURE  

**HEADER** :  
Fournit des infos essentielles sur le token, il est généralement composé de 2 parties.  
Il contient le type de token et l'algo de signature et/ou de chiffrement utilisé.
  
**PAYLOAD** (= Charge utile) :  
Contient les infos qui doivent être transmises à l'application. Les informations sont fournies en paires clé/valeur.

**SIGNATURE** :  


## Gestion des JWT : Côté Back ou Front ? 

Il est possible de gérer les jwt du côté back comme du côté front, mais chacun on leurs avantages : 

#### Gestion côté Back :
 - Avantages : 
    - **Sécurité** : + sûr car les tokens ne sont pas exposés au client.
    - **Contrôle** : Le serveur peut gérer les expirations, les rafraichissements et les validations.
- Inconvénients : 
    - **Complexité** : Nécessite une implémentation côté serveur.
    - **Performance** : Chaque requête nécessite de vérifier le JWT donc - performant.

#### Gestion côté Front : 
- Avantages : 
    - **Réactivité** : JWT stockés côté client permettent d'éviter les requêtes supplémentaires au serveur.
    - **Expérience utilisateur** : Utilisateurs restent connectés même après la fermeture du navigateur.
- Inconvénients : 
    - **Sécurité** : Les tokens sont exposés au client.
    - **Vulnérabilités** : Attaques XSS peuvent compromettre les tokens.

### Conclusion :  

**Gestion côté Back** :  
Appli plus sécurisée mais moins rapide  

**Gestion côté Front** :  
Appli plus rapide mais moins sécurisée (risque d'attaques XSS notamment.)