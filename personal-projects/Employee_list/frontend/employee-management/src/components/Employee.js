import "./Employee.css";
const Employee = ({ employee, deleteEmployee }) => {
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
                <a
                    onClick={(e, id) => deleteEmployee(e, employee.id)}
                    className="Employee--deleteBtn"
                >
                    Delete
                </a>
            </td>
        </tr>
    );
};

export default Employee;
