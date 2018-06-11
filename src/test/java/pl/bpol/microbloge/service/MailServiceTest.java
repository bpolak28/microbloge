package pl.bpol.microbloge.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bpol.microbloge.service.implementation.MailServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {

    MailService mailService = new MailServiceImpl(getJavaMailSender(),null);

    @Test
    public void sendMail(){

        boolean result = mailService.sendEmailToUser("bpolak28@gmail.com", "Siema", "Elo", "Me");
        Assert.assertEquals(true,result);
    }

    @Test
    public void readContentLocalResource() {
        InputStream in = getClass().getResourceAsStream("/attachments/mailtest.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String line;
            while (null != (line = reader.readLine())) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setProtocol("smtp");

        mailSender.setUsername("januszpioter555@gmail.com");
        mailSender.setPassword("januszpioter55");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.quitwait", "false");

        return mailSender;
    }

}
