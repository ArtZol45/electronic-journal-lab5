package ru.university.journal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(long id, String fullName) {
        boolean exists = students.stream()
                .anyMatch(student -> student.getId() == id);

        if (exists) {
            throw new IllegalArgumentException(
                    "Студент с таким ID уже существует"
            );
        }

        Student student = new Student(id, fullName);
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }
}
