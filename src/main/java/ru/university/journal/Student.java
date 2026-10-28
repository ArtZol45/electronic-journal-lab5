package ru.university.journal;

public class Student {

    private final long id;
    private final String fullName;

    public Student(long id, String fullName) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID студента должен быть положительным"
            );
        }

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException(
                    "ФИО студента не должно быть пустым"
            );
        }

        this.id = id;
        this.fullName = fullName.trim();
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
