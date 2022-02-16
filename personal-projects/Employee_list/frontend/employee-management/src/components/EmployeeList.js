import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import { useState, useEffect } from "react";
import "./EmployeeList.css";
import Employee from "./Employee";

const EmployeeList = () => {
    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [employees, setEmployees] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const respone = await EmployeeService.getEmployees();
                setEmployees(respone.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();
    }, []);

    const deleteEmployee = (e, id) => {
        e.preventDefault();
        EmployeeService.deleteEmployee(id).then((res) => {
            if (employees) {
                setEmployees((prevElement) => {
                    return prevElement.filter((employee) => employee.id !== id);
                });
            }
        });
    };

    return (
        <>
            <div className="EmployeeList">
                <div>
                    <button
                        className="EmployeeList--addEmployeeBtn"
                        onClick={() => navigate("/addEmployee")}
                    >
                        Add Employee
                    </button>
                </div>
                <div className="EmployeeList--Wrapper">
                    <table className="EmployeeList--Wrapper--header">
                        <thead className="EmpployeeList--Wrapper--header--title">
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email Id</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        {!loading && (
                            <tbody>
                                {employees.map((employee) => (
                                    <Employee
                                        employee={employee}
                                        deleteEmployee={deleteEmployee}
                                        key={employee.id}
                                    ></Employee>
                                ))}
                            </tbody>
                        )}
                    </table>
                </div>
            </div>
        </>
    );
};

export default EmployeeList;
