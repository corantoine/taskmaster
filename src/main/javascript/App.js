
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginForm from "./components/LoginForm";
import Tasks from "./components/Tasks";
import CreateUserForm from "./components/CreateUserForm";

function App() {

  return (
    <div>

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginForm />} />
          <Route path="/tasks" element={<Tasks />} />
          <Route path="/login" element={<CreateUserForm />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

