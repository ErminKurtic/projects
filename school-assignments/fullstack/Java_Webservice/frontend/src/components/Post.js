import React from "react";

export const Post = ({ post }) => {
    return (
        <div
            style={{
                border: "1px solid black",
                marginTop: "15px",
                padding: "1rem",
            }}
        >
            <h4>Title: {post.title}</h4>
            <p>{post.post}</p>
            <p>Creator: {post.creator}</p>
        </div>
    );
};
