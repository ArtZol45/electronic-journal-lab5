package ru.university.journal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentServiceTest {

    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService();
    }

    @Test
    void shouldAddStudent() {
        Student student = service.addStudent(1, "Иванов Иван");

        assertEquals(1, student.getId());
        assertEquals("Иванов Иван", student.getFullName());
        assertEquals(1, service.getAllStudents().size());
    }

    @Test
    void shouldRejectDuplicateId() {
        service.addStudent(1, "Иванов Иван");

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addStudent(1, "Петров Пётр")
        );
    }

    @Test
    void shouldRejectEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addStudent(1, " ")
        );
    }

    @Test
    void shouldRejectInvalidId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addStudent(0, "Иванов Иван")
        );
    }
}
