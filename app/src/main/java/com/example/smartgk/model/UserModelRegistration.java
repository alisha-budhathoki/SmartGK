package com.example.smartgk.model;

public class UserModelRegistration {
String status, response_time, results, message;

    public UserModelRegistration(String status, String response_time, String results, String message) {
        this.status = status;
        this.response_time = response_time;
        this.results = results;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
