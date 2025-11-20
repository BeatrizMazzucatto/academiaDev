package com.academiadev.model;

import java.time.Instant;

public class SupportTicket {
    private final String email; // requester (any user)
    private final String title;
    private final String message;
    private final Instant createdAt;

    public SupportTicket(String email, String title, String message) {
        this.email = email;
        this.title = title;
        this.message = message;
        this.createdAt = Instant.now();
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}


