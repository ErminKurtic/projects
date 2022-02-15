import React from "react";

export const HandlePost = ({ userLoggedIn, setStatusMessage, setPosts }) => {
    const defaultInput = { title: "", post: "" };
    const [input, setInput] = React.useState(defaultInput);

    const changeData = (e) => {
        setInput({ ...input, [e.target.name]: e.target.value });
    };

    const updatePostsAfterNewSubmit = async () => {
        await fetch("http://localhost:8080/post/all", {
            method: "GET",
            headers: {
                token: userLoggedIn,
            },
        })
            .then((response) => {
                return response.json();
            })
            .then((moreResponse) => {
                setPosts(moreResponse);
            })
            .catch((error) => {
                console.log(error);
            });
    };

    const createPostForm = async (e) => {
        e.preventDefault();

        fetch("http://localhost:8080/post/create", {
            method: "PUT",
            body: JSON.stringify({
                title: input.title,
                post: input.post,
            }),
            headers: {
                token: userLoggedIn,
                "Content-Type": "application/json",
            },
        })
            .then((response) => {
                return response.text();
            })
            .then((moreResponse) => {
                setStatusMessage(moreResponse);
                updatePostsAfterNewSubmit();
            })
            .catch((error) => {
                setStatusMessage(error);
            });
    };
    const deletePost = () => {
        fetch("http://localhost:8080/post/delete", {
            method: "DELETE",
            body: JSON.stringify({
                title: input.title,
            }),
            headers: {
                token: userLoggedIn,
                "Content-Type": "application/json",
            },
        }).catch((error) => {
            console.log(error);
        });
        updatePostsAfterNewSubmit();
    };

    const deleteAllPosts = () => {
        fetch("http://localhost:8080/post/deleteall", {
            method: "DELETE",
            headers: {
                token: userLoggedIn,
                "Content-Type": "application/json",
            },
        }).catch((error) => {
            console.log(error);
        });
        updatePostsAfterNewSubmit();
    };

    return (
        <div className="new-post-form">
            <form onSubmit={createPostForm}>
                <h3>Add a new Post / Enter the title of a post to delete:</h3>
                <input
                    type="text"
                    className="input"
                    name="title"
                    value={input.title}
                    placeholder="Post title"
                    onChange={changeData}
                />
                <br />
                <input
                    type="text"
                    className="input"
                    name="post"
                    value={input.post}
                    placeholder="Post content"
                    onChange={changeData}
                />
                <br />
                <button type="submit">Submit Post</button>
            </form>
            <button onClick={() => deletePost()}>Delete Post</button>
            <br />
            <button onClick={() => deleteAllPosts()}>
                Delete Associated Posts
            </button>
        </div>
    );
};
