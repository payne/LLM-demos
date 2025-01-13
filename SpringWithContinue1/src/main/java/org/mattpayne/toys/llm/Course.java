package org.mattpayne.toys.llm;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    // Getters and setters
}
