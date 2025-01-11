package org.mattpayne.toys.emailreminder.service;




import org.mattpayne.toys.emailreminder.model.Reminder;
import org.mattpayne.toys.emailreminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private EmailService emailService;

    public Reminder createReminder(Reminder reminder) {
        reminder.setSent(false);
        return reminderRepository.save(reminder);
    }

    @Scheduled(fixedRate = 60000) // Runs every minute
    public void processReminders() {
        LocalDateTime now = LocalDateTime.now();
        reminderRepository.findByScheduledTimeBeforeAndSentFalse(now)
                .forEach(reminder -> {
                    try {
                        emailService.sendEmail(
                                reminder.getEmailTo(),
                                reminder.getSubject(),
                                reminder.getMessage()
                        );
                        reminder.setSent(true);
                        reminderRepository.save(reminder);
                    } catch (Exception e) {
                        // Log the error but don't mark as sent
                        e.printStackTrace();
                    }
                });
    }
}

