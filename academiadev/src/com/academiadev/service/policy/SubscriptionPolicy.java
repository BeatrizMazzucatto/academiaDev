package com.academiadev.service.policy;

public interface SubscriptionPolicy {
    boolean canEnroll(int currentActiveEnrollments);
    int maxActiveEnrollments();
}


