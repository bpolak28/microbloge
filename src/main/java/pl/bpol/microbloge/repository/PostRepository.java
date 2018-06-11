package pl.bpol.microbloge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bpol.microbloge.model.Post;

public interface PostRepository extends CrudRepository<Post,Long> {
}
