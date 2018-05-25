package pl.bpol.microbloge.service;

import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bpol.microbloge.dao.UserDao;
import pl.bpol.microbloge.model.RegistrationResult;
import pl.bpol.microbloge.model.User;

public class UserService {

    private static Logger log = LogManager.getLogger(UserService.class);
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(){

    }

    public RegistrationResult registerNewUser(User newUser){
        Preconditions.checkNotNull(newUser,"null!!!");

        log.debug("registerNewUser()");
        RegistrationResult result = RegistrationResult.SUCCESS;

        if(userDao.checkIfUserExists(newUser)){
            log.debug("user already exists" + newUser);
            return result = RegistrationResult.USER_ALREADY_EXISTS;
        } else if (userDao.checkIfPasswordMissmatch(newUser)){
            return result = RegistrationResult.PASSWORD_MISSMATCH;
        } else if (userDao.checkIsLoginCorrect(newUser)){
            return result = RegistrationResult.INCORRECT_LOGIN;
        } else if (userDao.checkIsPasswordCorrect(newUser)){
            return result = RegistrationResult.INCORRECT_PASSWORD;
        } else {
            return result;
        }
    }

    public boolean deleteAccount(User user){
        log.debug("deleteAccount: " + user);
        if(userDao.checkIfUserExists(user)){
            userDao.deleteUser(user);
            return true;
        } else {
            log.debug("trying to delete non existent user!");
            return false;
        }

    }

}
