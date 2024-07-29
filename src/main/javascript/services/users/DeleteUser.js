import { baseApi } from '../apiConfig'

//Creation de la fonction async createUser()
export async function CreateUser(pseudo, prenom, nom, pays, email, password) {

const userURL =(baseApi, "/users")

    // Créer un objet contenant les options de requete (requete + reponse)
    const option = {
        //Type de la méthode
        method: 'DELETE',
        //Contenu envoyé et  ?
        header: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({
            //dénominations back/front pour faire la correspondance des données
            username: pseudo,
            firstname: prenom,
            lastname: nom,
            country: pays,
            email: email,
            password: password
        })
    }
    // gestion d'erreur try...catch
    try {
        const reponse = await fetch(userURL, option);
        if (!reponse.ok) {
            throw new Error(`HTTP error! Status: ${reponse.status}`)
        }
        alert('User created successfully !');
    } catch (error) {
        alert("User creation aborted !");
        throw error;
    }
};


