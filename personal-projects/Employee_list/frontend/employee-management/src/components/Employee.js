import "./Employee.css";
const Employee = ({ employee }) => {
    return (
        <tr key={employee.id}>
            <td>
                <div>{employee.firstName}</div>
            </td>
            <td>
                <div>{employee.lastName}</div>
            </td>
            <td>
                <div>{employee.emailId}</div>
            </td>
            <td>
                <a href="#">Edit</a>
                <a href="#" className="Employee--deleteBtn">
                    Delete
                </a>
            </td>
        </tr>
    );
};

export default Employee;
