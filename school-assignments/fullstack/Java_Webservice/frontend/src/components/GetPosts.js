import React from "react";

import { Post } from "./Post";

export const GetPosts = ({
    userLoggedIn,
    setStatusMessage,
    posts,
    setPosts,
}) => {
    React.useEffect(() => {
        fetch("http://localhost:8080/post/all", {
            method: "GET",
        })
            .then((response) => {
                return response.json();
            })
            .then((moreResponse) => {
                setPosts(moreResponse);
            })
            .catch((error) => {
                setStatusMessage(error);
            });
    }, []);

    return (
        <div>
            <h3>Posts</h3>
            {posts.length > 0
                ? posts.map((post, index) => (
                      <Post
                          post={post}
                          key={index}
                          userLoggedIn={userLoggedIn}
                      />
                  ))
                : "There are no posts!"}
        </div>
    );
};
