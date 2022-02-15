import React from "react";

export const RegisterUser = ({ setStatusMessage }) => {
    const defaultInput = { name: "", password: "" };
    const [input, setInput] = React.useState(defaultInput);

    const changeData = (e) => {
        setInput({ ...input, [e.target.name]: e.target.value });
    };

    const registerForm = async (e) => {
        e.preventDefault();

        fetch("http://localhost:8080/user/register", {
            method: "PUT",
            body: JSON.stringify({
                username: input.name,
                password: input.password,
            }),
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => {
                return response.text();
            })
            .then((moreResponse) => {
                setStatusMessage(moreResponse);
            })
            .catch((error) => {
                setStatusMessage(error);
            });
    };

    return (
        <div className="register-form">
            <form onSubmit={registerForm}>
                <h3>Register a new account here:</h3>
                <input
                    type="text"
                    className="input"
                    name="name"
                    value={input.name}
                    placeholder="Username"
                    onChange={changeData}
                />
                <br />
                <input
                    type="password"
                    className="input"
                    name="password"
                    value={input.password}
                    placeholder="Password"
                    onChange={changeData}
                />
                <br />
                <button type="submit">Register User:</button>
            </form>
        </div>
    );
};
