package pl.bpol.microbloge.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.bpol.microbloge.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
