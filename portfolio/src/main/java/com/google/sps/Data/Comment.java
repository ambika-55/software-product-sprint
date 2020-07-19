package com.google.sps.Data;

// Structure of each comment
public class Comment{

    // Unique ID to define each comment
    private long id;

    // Comment message
    private String text;

    // Timestamp
    private long timestamp;

    private String emailId;

    public Comment(long id, String text, long timestamp, String emailId){
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.emailId = emailId;
    }
}
