package me.code.springposts.post;

import me.code.springposts.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;


    @GetMapping("/all")
    @ResponseBody
    public Collection<Post> getPosts(HttpServletResponse response) {
        Collection<Post> postResult = postService.getPosts();
        if (postResult.isEmpty()) {
            response.setStatus(404);
        }
        return postResult;
    }

    @PutMapping("/create")
    public String createPost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response) {
        if (userService.validate(token) == null) {
            response.setStatus(401);
            return null;
        }

        int result = postService.createPost(token, post);
        switch (result) {
            case 1:
                response.setStatus(409);
                return "There is already a post with that title, choose a unique title";
            case 0:
                return "Post has been submitted";
            default:
                response.setStatus(500);
                return "Something went wrong.";
        }
    }

    @DeleteMapping("/delete")
    public String deletePost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response){
        if (userService.validate(token) == null) {
            response.setStatus(401);
            return null;
        }

        int result = postService.deletePost(token, post);
        switch (result) {
            case 1: response.setStatus(401);
                return "Unauthorized to delete that post";
            case 0:
                response.setStatus(200);
                return "Post removed";
            default:
                response.setStatus(500);
                return "Something went wrong.";
        }
    }

    @DeleteMapping("/deleteall")
    public String deleteAllPost(@RequestHeader("token") String token, HttpServletResponse response){
        if (userService.validate(token) == null) {
            response.setStatus(401);
            return null;
        }

        boolean deleteAllPost = postService.deleteAllPost(token);
        if (deleteAllPost) {
            response.setStatus(200);
            return "All posts removed";
        }
            response.setStatus(500);
            return "Something went wrong.";
    }
}
