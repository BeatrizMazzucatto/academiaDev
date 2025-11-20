package com.academiadev.model;

public interface SubscriptionPlan {

    boolean canEnroll(long currentEnrollments);

    String getPlanName();

}
