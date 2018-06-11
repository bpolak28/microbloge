package pl.bpol.microbloge.service;

public interface MailSenderJob {
    void sendSubscribtionsAboutNewMessages();
    void sendSubscribtionsAboutNewComments();
}
