# Spring Boot Reminder Application

This project is a Spring Boot application that sends reminder emails on a schedule using the FastMail service.

## Features

- Sends reminder emails to specified recipients.
- Configurable email templates.
- Scheduled email sending using Spring's scheduling capabilities.

## Project Structure

```
spring-boot-reminder
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── reminder
│   │   │               ├── ReminderApplication.java
│   │   │               ├── config
│   │   │               │   └── MailConfig.java
│   │   │               ├── service
│   │   │               │   └── EmailService.java
│   │   │               └── scheduler
│   │   │                   └── ReminderScheduler.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates
│   │           └── reminder-email.html
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   cd spring-boot-reminder
   ```

2. Update the `application.properties` file with your FastMail credentials and SMTP settings.

3. Build the project using Maven:
   ```
   ./mvnw clean install
   ```

4. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

## Usage

The application will automatically send reminder emails based on the schedule defined in the `ReminderScheduler` class. You can customize the email content by modifying the `reminder-email.html` template.

## Dependencies

This project uses the following dependencies:
- Spring Boot
- Spring Email
- Spring Scheduling

## License

This project is licensed under the MIT License.