import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.reminder.service.EmailService;

@Component
public class ReminderScheduler {

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Sends reminder emails every day at 9 AM
    public void sendReminderEmails() {
        String recipient = "recipient@example.com"; // Replace with actual recipient
        String subject = "Daily Reminder";
        String body = "This is your daily reminder email.";

        emailService.sendReminderEmail(recipient, subject, body);
    }
}