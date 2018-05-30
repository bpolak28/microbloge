package pl.bpol.microbloge.service;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bpol.microbloge.model.RegistrationResult;
import pl.bpol.microbloge.model.User;
import pl.bpol.microbloge.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static Logger log = LogManager.getLogger(UserService.class);


    private UserRepository userRepository;
//    private UserDao userDao;

//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService(){

    }

    public RegistrationResult registerNewUser(User newUser){
        Preconditions.checkNotNull(newUser,"null!!!");

        log.debug("registerNewUser()");
        RegistrationResult result = RegistrationResult.SUCCESS;

        if(userRepository.existsById(newUser.getId())){
            log.debug("user already exists" + newUser);
            return result = RegistrationResult.USER_ALREADY_EXISTS;
//        } else if (userDao.checkIfPasswordMissmatch(newUser)){
//            return result = RegistrationResult.PASSWORD_MISSMATCH;
//        } else if (userDao.checkIsLoginCorrect(newUser)){
//            return result = RegistrationResult.INCORRECT_LOGIN;
//        } else if (userDao.checkIsPasswordCorrect(newUser)){
//            return result = RegistrationResult.INCORRECT_PASSWORD;
        } else {
            userRepository.save(newUser);
            return result;
        }
    }

    public boolean deleteAccount(User user){
        log.debug("deleteAccount: " + user);
        if(userRepository.existsById(user.getId())){
            userRepository.delete(user);
            return true;
        } else {
            log.debug("trying to delete non existent user!");
            return false;
        }

    }

    public List<User> findAllUsers(){
        List<User> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

}
