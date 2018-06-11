package pl.bpol.microbloge.service.implementation;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import pl.bpol.microbloge.service.MailService;

public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;

    private SimpleMailMessage simpleMailMessage;

    public MailServiceImpl(JavaMailSender javaMailSender, SimpleMailMessage simpleMailMessage) {
        this.javaMailSender = javaMailSender;
        this.simpleMailMessage = simpleMailMessage;
    }

    public void setMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public boolean sendEmailToUser(String address, String title, String message,String from) {

        boolean result = true;
        SimpleMailMessage myMessage = new SimpleMailMessage();
        myMessage.setTo(address);
        myMessage.setSubject(title);
        myMessage.setText(message);
        myMessage.setFrom(from);

        try{
            javaMailSender.send(myMessage);
        }catch (MailException e){
            result = false;
            System.err.println("Error occured during mail sanding: [%s]"+e);
        }

        return result;
    }

    @Override
    public boolean sendEmailToUserWithAttachment(String address, String title, String message, String from, String resourcePath) {

        boolean result = true;
        SimpleMailMessage myMessage = new SimpleMailMessage();
        myMessage.setTo(address);
        myMessage.setSubject(title);
        myMessage.setText(message);
        myMessage.setFrom(from);

        try{
            javaMailSender.send(myMessage);
        }catch (MailException e){
            result = false;
            System.err.println("Error occured during mail sanding: [%s]"+e);
        }
        return result;
    }

    @Override
    public String toString() {
        return "MailServiceImpl{" +
                "mailSender=" + javaMailSender +
                ", simpleMailMessage=" + simpleMailMessage +
                '}';
    }
}
