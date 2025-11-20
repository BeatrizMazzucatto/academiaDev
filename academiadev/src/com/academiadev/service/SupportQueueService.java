package com.academiadev.service;

import com.academiadev.model.SupportTicket;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class SupportQueueService {
    private final Deque<SupportTicket> queue = new ArrayDeque<>();

    public void enqueue(SupportTicket ticket) {
        queue.addLast(ticket);
    }

    public Optional<SupportTicket> peekNext() {
        return Optional.ofNullable(queue.peekFirst());
    }

    public Optional<SupportTicket> processNext() {
        return Optional.ofNullable(queue.pollFirst());
    }

    public int size() {
        return queue.size();
    }
}


