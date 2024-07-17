import "../styles/loginForm.css"
import { useNavigate } from "react-router-dom";

export default function LoginForm() {

    // const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
    }


    return (
        <div className="container">
            <form action="submit" onSubmit={handleSubmit}>
                    <h3> Connexion </h3>

                    <input
                        type="text"
                        name="username"
                        placeholder="saisissez votre identifiant"
                    ></input>
                    <input
                        type="password"
                        name="password"
                        placeholder="Saisissez votre mot de passe" />
                    <button>Valider</button>
            </form>
        </div>
    )

}