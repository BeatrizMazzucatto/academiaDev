package com.academiadev.service.policy;

public class BasicPlanPolicy implements SubscriptionPolicy {
    private static final int LIMIT = 3;

    @Override
    public boolean canEnroll(int currentActiveEnrollments) {
        return currentActiveEnrollments < LIMIT;
    }

    @Override
    public int maxActiveEnrollments() {
        return LIMIT;
    }
}


