package org.mattpayne.toys.emailreminder.controller;




import org.mattpayne.toys.emailreminder.model.Reminder;
import org.mattpayne.toys.emailreminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder saved = reminderService.createReminder(reminder);
        return ResponseEntity.ok(saved);
    }
}
