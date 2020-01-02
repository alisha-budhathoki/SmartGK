package com.example.smartgk.model;

public class Exams {
    String currentDate, startDate, endDate, examTitle;

    public Exams() {
        this.currentDate = currentDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.examTitle = examTitle;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }
}
