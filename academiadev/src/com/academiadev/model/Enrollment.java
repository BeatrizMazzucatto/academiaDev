package com.academiadev.model;

public class Enrollment {
    private final Student student;
    private final Course course;
    private int progressPercent; // 0..100

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.progressPercent = 0;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(int progressPercent) {
        if (progressPercent < 0 || progressPercent > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100");
        }
        if (this.progressPercent > progressPercent) {
            throw new IllegalArgumentException("O progresso não pode ser menor que o atual (" + this.progressPercent + "%).");
        }
        this.progressPercent = progressPercent;
    }
}


