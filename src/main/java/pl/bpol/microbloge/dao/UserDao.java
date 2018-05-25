package pl.bpol.microbloge.dao;

import pl.bpol.microbloge.model.User;

public interface UserDao {

    void saveNewUser(User user);

    boolean checkIfUserExists(User user);

    void deleteUser(User user);

    void updateUser(User user);

    boolean checkIfPasswordMissmatch(User user);

    boolean checkIsLoginCorrect(User user);

    boolean checkIsPasswordCorrect(User user);
}
