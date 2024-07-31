import { useNavigate } from "react-router-dom";
import "../styles/loginForm.css"

const LoginForm = () => {
        const navigate = useNavigate();

    const handleSubmit = 
    async (e) => {
        e.preventDefault(); 
    
        const {pseudo, password} = Object.fromEntries(
            new FormData(e.target)
        );

        try {
            if (condition) {
                
            }
            
        } catch (error) {
            
        }

    }


    return (
        <div className="form-container">
            <form className="login-form" action="submit" onSubmit={handleSubmit}>
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