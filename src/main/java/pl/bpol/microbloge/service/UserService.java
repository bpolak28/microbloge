package pl.bpol.microbloge.service;

import com.google.common.base.Preconditions;
import pl.bpol.microbloge.dao.UserDao;
import pl.bpol.microbloge.model.RegistrationResult;
import pl.bpol.microbloge.model.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(){

    }

    public RegistrationResult registerNewUser(User newUser){
        Preconditions.checkNotNull(newUser,"null!!!");

        RegistrationResult result = RegistrationResult.SUCCESS;

        if(userDao.checkIfUserExists(newUser)){
            return result = RegistrationResult.USER_ALREADY_EXISTS;
        }



        return null;
    }

}
