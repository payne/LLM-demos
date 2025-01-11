package org.mattpayne.toys.emailreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailReminderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailReminderApplication.class, args);
    }
}


