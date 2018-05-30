package pl.bpol.microbloge.controller;

import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bpol.microbloge.model.RegistrationResult;
import pl.bpol.microbloge.model.User;
import pl.bpol.microbloge.service.PostService;
import pl.bpol.microbloge.service.UserService;

@Controller
public class MainController {

    UserService userService;

    PostService postService;

    public MainController() {
    }

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String signIn(@RequestParam String login,
                         @RequestParam String password1,
                         @RequestParam String password2){
        User newUser = new User(login,password1,password2);
        RegistrationResult result = userService.registerNewUser(newUser);

        String response = "Registration-fail";
        if(result == RegistrationResult.SUCCESS){
            response = "Registration-ok";
        } else if(result == RegistrationResult.USER_ALREADY_EXISTS){
            response = "Registration-already-exists";
        }
        return "redirect:/giveMeAllUsers";
    }

    @RequestMapping(value = "/editpost", method = RequestMethod.GET)
    public String editNewPost(Model model){
        postService.
    }
}
