package pl.bpol.microbloge.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "pl.bpol.microbloge")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
