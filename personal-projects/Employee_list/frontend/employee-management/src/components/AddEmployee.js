import { useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import "./AddEmployee.css";

const AddEmployee = () => {
    const [employee, setEmployee] = useState({
        id: "",
        firstName: "",
        lastName: "",
        emailId: "",
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        const value = e.target.value;
        setEmployee({ ...employee, [e.target.name]: value });
    };

    const saveEmployee = (e) => {
        /* Disable refresh of website on save*/
        e.preventDefault();
        EmployeeService.saveEmployee(employee)
            .then((response) => {
                console.log(response);
                navigate("/employeeList");
            })
            .catch((error) => {
                console.log(error);
            });
    };

    const reset = (e) => {
        e.preventDefault();
        setEmployee({ id: "", firstName: "", lastName: "", emailId: "" });
    };

    return (
        <div className="AddEmployee">
            <div>
                <h2>Add Employee</h2>
            </div>
            <div className="AddEmployee--form">
                <label>First Name:</label>
                <input
                    type="text"
                    className="AddEmployee--form__input"
                    name="firstName"
                    value={employee.firstName}
                    onChange={(e) => handleChange(e)}
                ></input>
            </div>
            <div className="AddEmployee--form">
                <label>Last Name:</label>
                <input
                    type="text"
                    className="AddEmployee--form__input"
                    name="lastName"
                    value={employee.lastName}
                    onChange={(e) => handleChange(e)}
                ></input>
            </div>
            <div className="AddEmployee--form">
                <label>Email:</label>
                <input
                    type="email"
                    className="AddEmployee--form__input"
                    name="emailId"
                    value={employee.emailId}
                    onChange={(e) => handleChange(e)}
                ></input>
            </div>
            <div className="AddEmployee--buttonContainer">
                <div>
                    <button
                        onClick={saveEmployee}
                        className="AddEmployee--form__saveButton"
                    >
                        Save
                    </button>
                </div>
                <div>
                    <button
                        className="AddEmployee--form__clearButton"
                        onClick={reset}
                    >
                        Clear
                    </button>
                </div>
            </div>
        </div>
    );
};

export default AddEmployee;
