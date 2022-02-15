import React from "react";
import "./App.css";

import { RegisterUser } from "./components/RegisterUser";
import { LoginUser } from "./components/LoginUser";
import { HandlePost } from "./components/HandlePost";
import { GetPosts } from "./components/GetPosts";

function App() {
    const [statusMessage, setStatusMessage] = React.useState();
    const [userLoggedIn, setUserLoggedIn] = React.useState();
    const [posts, setPosts] = React.useState([]);

    return (
        <div>
            <div className="User-container">
                <div className="Register-container">
                    <RegisterUser setStatusMessage={setStatusMessage} />
                    <h3 style={{ color: "red" }}> {statusMessage}</h3>
                </div>
                <div className="Login-container">
                    <LoginUser
                        setUserLoggedIn={setUserLoggedIn}
                        userLoggedIn={userLoggedIn}
                        setPosts={setPosts}
                    />
                </div>
            </div>
            <div className="Create_post-container">
                <HandlePost
                    setStatusMessage={setStatusMessage}
                    userLoggedIn={userLoggedIn}
                    setPosts={setPosts}
                />
            </div>
            <div className="Post_list-container">
                <GetPosts
                    setStatusMessage={setStatusMessage}
                    userLoggedIn={userLoggedIn}
                    posts={posts}
                    setPosts={setPosts}
                />
            </div>
        </div>
    );
}

export default App;
