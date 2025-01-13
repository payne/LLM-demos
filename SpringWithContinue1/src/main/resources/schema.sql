CREATE TABLE students (
  id INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE courses (
  id INT PRIMARY KEY,
  title VARCHAR(255)
);

CREATE TABLE student_courses (
  student_id INT NOT NULL,
  course_id INT NOT NULL,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES students(id),
  FOREIGN KEY (course_id) REFERENCES courses(id)
);