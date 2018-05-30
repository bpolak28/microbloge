package pl.bpol.microbloge.service;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import static pl.bpol.microbloge.model.RegistrationResult.*;
import pl.bpol.microbloge.model.User;
import pl.bpol.microbloge.repository.UserRepository;

public class UserServiceTest {

    UserRepository dummyRepository = mock(UserRepository.class);
    UserService userService = new UserService(dummyRepository);
    User newUser = new User("Bartek","Polak","Polak");;

    @Test
    public void registerNewUser_positiveCase(){

        when(dummyRepository.existsById(newUser.getId())).thenReturn(false);

        Assert.assertEquals(SUCCESS, userService.registerNewUser(newUser));
    }

    @Test
    public void registerNewUser_alreadyExists(){

        when(dummyRepository.existsById(newUser.getId())).thenReturn(true);

        Assert.assertEquals(USER_ALREADY_EXISTS, userService.registerNewUser(newUser));

    }

    @Test
    public void deleteAccount_success(){
        when(dummyRepository.existsById(newUser.getId())).thenReturn(true);

        Assert.assertEquals(true, userService.deleteAccount(newUser));
    }

    @Test
    public void deleteAccount_notExists(){
        when(dummyRepository.existsById(newUser.getId())).thenReturn(false);

        Assert.assertEquals(false, userService.deleteAccount(newUser));
    }

}
