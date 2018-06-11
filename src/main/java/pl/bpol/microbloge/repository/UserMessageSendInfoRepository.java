package pl.bpol.microbloge.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bpol.microbloge.model.UserMessageSendInfo;

public interface UserMessageSendInfoRepository extends CrudRepository<UserMessageSendInfo,Long> {
}
