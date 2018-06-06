package pl.bpol.microbloge.service.implementation;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import pl.bpol.microbloge.service.MailService;

public class MailServiceImpl implements MailService {

    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public boolean sendEmailToUser(String address, String title, String message,String from) {

        SimpleMailMessage myMessage = new SimpleMailMessage();
        myMessage.setTo(address);
        myMessage.setSubject(title);
        myMessage.setText(message);
        myMessage.setFrom(from);

        try{
            mailSender.send(myMessage);
        }catch (MailException e){
            System.err.println("Error occured during mail sanding: [%s]"+e);
        }


        return false;
    }
}
