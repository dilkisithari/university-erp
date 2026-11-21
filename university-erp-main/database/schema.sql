CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT UQ_Student_ID UNIQUE (student_id),
    CONSTRAINT UQ_Student_Email UNIQUE (email)
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(20) NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    credits INT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT UQ_Course_Code UNIQUE (course_code)
);


CREATE TABLE enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATE DEFAULT (CURRENT_DATE),
    status VARCHAR(20) DEFAULT 'ACTIVE',
    CONSTRAINT UQ_Student_Course UNIQUE (student_id, course_id),
    CONSTRAINT FK_Enrollments_Students FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    CONSTRAINT FK_Enrollments_Courses FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);


CREATE TABLE exams (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    exam_code VARCHAR(20) NOT NULL,
    exam_date DATE NOT NULL,
    max_marks INT DEFAULT 100,
    CONSTRAINT UQ_Exam_Code UNIQUE (exam_code),
    CONSTRAINT FK_Exams_Courses FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

CREATE TABLE exam_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    exam_id INT NOT NULL,
    student_id INT NOT NULL,
    marks_obtained DECIMAL(5,2),
    grade VARCHAR(5),
    remarks VARCHAR(100),
    CONSTRAINT UQ_Exam_Student UNIQUE (exam_id, student_id),
    CONSTRAINT FK_Results_Exams FOREIGN KEY (exam_id) REFERENCES exams(id) ON DELETE CASCADE,
    CONSTRAINT FK_Results_Students FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);


CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    CONSTRAINT UQ_Student_Course_Date UNIQUE (student_id, course_id, attendance_date),
    CONSTRAINT FK_Attendance_Students FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    CONSTRAINT FK_Attendance_Courses FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
