import { useEffect, useState } from "react";
import Employee from "./Employee";

function EmployeeList() {
    const [employees, setEmployees] = useState([
        {
            name: "Ermin Kurtic",
            email: "meanymachine@gmail.com",
            phone: "0708279837",
            skills: "React, C++, Java, Nodejs",
            avatar: "https://i.imgur.com/t9HFQvX.png",
        },
        {
            name: "Test test",
            email: "test@hotmail.com",
            phone: "0712254881",
            skills: "Python, SQL, Go",
            avatar: "https://i.imgur.com/Q9qFt3m.png",
        },
    ]);

    function handleAddNewEmp() {
        setEmployees((prevState) => {
            return [
                ...prevState,
                {
                    name: "Geralt of Rivia",
                    email: "geralt@hotmail.com",
                    phone: "070548412",
                    skills: "None",
                    avatar: "https://i.imgur.com/ebHfuth.png",
                },
            ];
        });
    }
    return (
        <div>
            <h3>EmployeeList</h3>
            <button onClick={handleAddNewEmp}>Add Employee</button>
            {employees.map((employee) => (
                <Employee EmployeeData={employee} />
            ))}
        </div>
    );
}

export default EmployeeList;
