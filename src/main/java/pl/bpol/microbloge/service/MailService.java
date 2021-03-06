package pl.bpol.microbloge.service;

public interface MailService {
    boolean sendEmailToUser(String address,String title,String message,String from);
    boolean sendEmailToUserWithAttachment(String address,String title,String message,String from,String resourcePath);
}
