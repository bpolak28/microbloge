package pl.bpol.microbloge.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bpol.microbloge.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
