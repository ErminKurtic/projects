package me.code.springposts.post;

import me.code.springposts.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository {

    private Map<String, Post> posts = new HashMap<>();

    public Post get(String title) {
        return posts.get(title.toLowerCase());
    }

    public void save(Post post) {
        posts.put(post.getTitle().toLowerCase(), post);
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }

    public void delete(Post post) {
        posts.remove(post.getTitle().toLowerCase());
    }

    public void clearAllPosts(User validatedUser) {
        Collection <Post> uniPosts =
                posts.values()
                        .stream()
                        .filter(x -> x.getCreator().toLowerCase().equals(validatedUser.getName().toLowerCase()))
                        .collect(Collectors.toList());

        for (Post uniPost : uniPosts) {
            posts.remove(uniPost.getTitle().toLowerCase());
        }
    }
}
