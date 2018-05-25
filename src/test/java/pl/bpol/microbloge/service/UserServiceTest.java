package pl.bpol.microbloge.service;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import pl.bpol.microbloge.dao.UserDao;
import static pl.bpol.microbloge.model.RegistrationResult.*;
import pl.bpol.microbloge.model.User;

public class UserServiceTest {

    UserDao dummyDao = mock(UserDao.class);

    UserService userService = new UserService(dummyDao);

    User newUser = new User("Bartek","Polak","Polak");;

    @Test
    public void registerNewUser_positiveCase(){

        when(dummyDao.checkIfUserExists(newUser)).thenReturn(false);
        when(dummyDao.checkIfPasswordMissmatch(newUser)).thenReturn(false);
        when(dummyDao.checkIsLoginCorrect(newUser)).thenReturn(false);
        when(dummyDao.checkIsPasswordCorrect(newUser)).thenReturn(false);

        Assert.assertEquals(SUCCESS,userService.registerNewUser(newUser));
    }

    @Test
    public void registerNewUser_alreadyExists(){

        when(dummyDao.checkIfUserExists(newUser)).thenReturn(true);

        Assert.assertEquals(USER_ALREADY_EXISTS,userService.registerNewUser(newUser));

    }

    @Test
    public void registerNewUser_passwordMissmatch(){

        when(dummyDao.checkIfPasswordMissmatch(newUser)).thenReturn(true);

        Assert.assertEquals(PASSWORD_MISSMATCH,userService.registerNewUser(newUser));

    }

    @Test
    public void deleteAccount_success(){
        when(dummyDao.checkIfUserExists(newUser)).thenReturn(true);

        Assert.assertEquals(true,userService.deleteAccount(newUser));
    }

    @Test
    public void deleteAccount_notExists(){
        when(dummyDao.checkIfUserExists(newUser)).thenReturn(false);

        Assert.assertEquals(false,userService.deleteAccount(newUser));
    }

}
