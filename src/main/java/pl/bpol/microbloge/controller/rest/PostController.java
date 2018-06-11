package pl.bpol.microbloge.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bpol.microbloge.model.Post;

@Controller
public class PostController {

    @GetMapping("/add-new-post")
    public String addNewPost(Post newPost) {
//        throw new IllegalStateException("Not implemented");
        return "";
    }

    @GetMapping("/edit-user-post")
    public String editPost(Post userPost, Model model) {
        model.addAttribute("header", userPost.getPostHeader());
        model.addAttribute("note", userPost.getNote());
        return "post_form";
    }
}
