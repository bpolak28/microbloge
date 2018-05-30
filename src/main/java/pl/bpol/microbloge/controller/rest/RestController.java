package pl.bpol.microbloge.controller.rest;


import org.springframework.web.bind.annotation.GetMapping;
import pl.bpol.microbloge.model.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/giveMeNewUser")
    public User giveMeNewUser(){
        return new User("Bartek","pass","pass");
    }

}
