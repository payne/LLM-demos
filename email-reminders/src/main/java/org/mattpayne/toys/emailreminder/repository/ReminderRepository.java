package org.mattpayne.toys.emailreminder.repository;




import org.mattpayne.toys.emailreminder.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByScheduledTimeBeforeAndSentFalse(LocalDateTime now);
}
