package com.academiadev.service.policy;

public class PremiumPlanPolicy implements SubscriptionPolicy {
    @Override
    public boolean canEnroll(int currentActiveEnrollments) {
        return true;
    }

    @Override
    public int maxActiveEnrollments() {
        return Integer.MAX_VALUE;
    }
}


