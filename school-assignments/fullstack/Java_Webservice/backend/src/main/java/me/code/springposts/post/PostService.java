package me.code.springposts.post;

import me.code.springposts.user.User;
import me.code.springposts.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.Collection;

@Service
public class PostService {

    @Autowired
    UserService userService;

    @Autowired
    PostRepository postRepository;


    public Collection<Post> getPosts() {
        return postRepository.getPosts();
    }

    public int createPost(@RequestHeader("token") String token, @RequestBody Post post) {
       User user = userService.validate(token);

        Post existing = postRepository.get(post.getTitle());
        if (existing != null)
            return 1;

        post.setCreator(user.getName());
        postRepository.save(post);

        return 0;
    }
    public int deletePost(String token, @RequestBody Post post) {
        User validateUser = userService.validate(token);
        Post validatedPost = postRepository.get(post.getTitle());

        if(!validatedPost.getCreator().equals(validateUser.getName())) {
            return 1;
        }
        postRepository.delete(validatedPost);
        return 0;
    }


    public boolean deleteAllPost(String token) {
        User validateUser = userService.validate(token);
        postRepository.clearAllPosts(validateUser);
        return postRepository.getPosts().stream().filter(x -> x.getCreator().toLowerCase().equals(validateUser.getName().toLowerCase())).count() == 0;
    }
}



