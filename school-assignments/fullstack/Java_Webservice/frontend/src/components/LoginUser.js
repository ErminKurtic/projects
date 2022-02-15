import React from "react";

export const LoginUser = ({
    userLoggedIn,
    setUserLoggedIn,
    setStatusMessage,
}) => {
    const defaultInput = { name: "", password: "" };
    const [input, setInput] = React.useState(defaultInput);

    const changeData = (e) => {
        setInput({ ...input, [e.target.name]: e.target.value });
    };

    const loginForm = async (e) => {
        e.preventDefault();

        fetch("http://localhost:8080/user/login", {
            method: "POST",
            headers: {
                username: input.name,
                password: input.password,
            },
        })
            .then((response) => {
                return response.text();
            })
            .then((data) => {
                setUserLoggedIn(data);
            })
            .catch((error) => {
                setStatusMessage(error);
            });
    };

    const logoutUser = () => {
        fetch("http://localhost:8080/user/logout", {
            method: "POST",
            headers: {
                token: userLoggedIn,
            },
        })
            .catch((error) => {
                console.log(error);
            })
            .then(() => {
                setUserLoggedIn();
            });
    };

    return (
        <div className="login-form">
            <form onSubmit={loginForm}>
                <h3>Login with credentials here:</h3>
                <input
                    type="text"
                    className="input"
                    name="name"
                    value={input.name}
                    placeholder="Enter Username"
                    onChange={changeData}
                />
                <br />
                <input
                    type="password"
                    className="input"
                    name="password"
                    value={input.password}
                    placeholder="Enter Password"
                    onChange={changeData}
                />
                <br />
                <button type="submit">Login User</button>
            </form>
            <button onClick={() => logoutUser()}>Logout User</button>
        </div>
    );
};
