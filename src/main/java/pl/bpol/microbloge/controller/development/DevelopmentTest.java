package pl.bpol.microbloge.controller.development;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bpol.microbloge.model.User;
import pl.bpol.microbloge.service.UserService;

import java.util.List;

@RestController
public class DevelopmentTest {

    private UserService userServiceImpl;

    @Autowired
    public DevelopmentTest(UserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/giveMeAllUsers")
    public List<User> giveMeAllRegistredUsers(){

        return userServiceImpl.findAllUsers();
    }



}
