import { BrowserRouter } from "react-router-dom";
import "./App.css";
import AddEmployee from "./components/AddEmployee";
import EmployeeList from "./components/EmployeeList";
import Navbar from "./components/Navbar";

function App() {
    return (
        <>
            <BrowserRouter>
                <Navbar />
                <AddEmployee />
                <EmployeeList />
            </BrowserRouter>
        </>
    );
}

export default App;
