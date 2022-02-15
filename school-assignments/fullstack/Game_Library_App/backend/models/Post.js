const mongoose = require("mongoose");

const PostSchema = mongoose.Schema({
    title: {
        type: String,
        required: true,
    },
    genre: {
        type: String,
        required: true,
    },
    playtime: {
        type: Number,
        required: true,
    },
});

module.exports = mongoose.model("Post", PostSchema);
