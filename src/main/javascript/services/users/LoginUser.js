import { baseApi } from '../apiConfig'

//Creation de la fonction async createUser()
export async function loginUser(pseudo, password) {

    const userURL = new URL("http://localhost:8080/taskmaster/users")

    // Créer un objet contenant les options de requete (requete + reponse)
    const option = {
        //Type de la méthode
        method: 'POST',
        //Contenu envoyé et  ?
        header: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({
            //dénominations back/front pour faire la correspondance des données
            username: pseudo,
            password: password
        })
    }
    // gestion d'erreur try...catch
    try {
        const reponse = await fetch(userURL, option);
        if (!reponse.ok) {
            throw new Error(`HTTP error! Status: ${reponse.status}`)
        }
        alert('Connexion : success !');
    } catch (error) {
        alert("You failed to connect !");
        throw error;
    }
};


