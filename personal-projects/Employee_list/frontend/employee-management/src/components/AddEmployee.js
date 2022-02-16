import "./AddEmployee.css";

const AddEmployee = () => {
    return (
        <div className="AddEmployee">
            <div>
                <h2>Add Employee</h2>
            </div>
            <div className="AddEmployee--form">
                <label>First Name:</label>
                <input type="text" className="AddEmployee--form__input"></input>
            </div>
            <div className="AddEmployee--form">
                <label>Last Name:</label>
                <input type="text" className="AddEmployee--form__input"></input>
            </div>
            <div className="AddEmployee--form">
                <label>Email:</label>
                <input
                    type="email"
                    className="AddEmployee--form__input"
                ></input>
            </div>
            <div className="AddEmployee--buttonContainer">
                <div>
                    <button className="AddEmployee--form__saveButton">
                        Save
                    </button>
                </div>
                <div>
                    <button className="AddEmployee--form__clearButton">
                        Clear
                    </button>
                </div>
            </div>
        </div>
    );
};

export default AddEmployee;
