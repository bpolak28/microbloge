package pl.bpol.microbloge.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class UserMessageSendInfo {
    private long id;
    private Map<User, LocalDateTime> lastMessageSentTimestamps;

    public UserMessageSendInfo(Map<User, LocalDateTime> lastMessageSentTimestamps) {
        this.lastMessageSentTimestamps = lastMessageSentTimestamps;
    }

    public Optional<LocalDateTime> getTimeOfLastSentMessage(User user) {
        return Optional.ofNullable(lastMessageSentTimestamps.get(user));
    }

    public void setTimeOfLastSentMessageForUser(User user, LocalDateTime timestamp) {
        lastMessageSentTimestamps.put(user, timestamp);
    }
}
