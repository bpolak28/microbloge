package pl.bpol.microbloge.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bpol.microbloge.model.Mail;

public interface MailRepository extends CrudRepository<Mail,Long> {
}
