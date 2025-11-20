package com.academiadev.service.policy;

import com.academiadev.model.BasicPlan;
import com.academiadev.model.SubscriptionPlan;

public class SubscriptionPolicyProvider {
    private final SubscriptionPolicy basicPolicy = new BasicPlanPolicy();
    private final SubscriptionPolicy premiumPolicy = new PremiumPlanPolicy();

    public SubscriptionPolicy forPlan(SubscriptionPlan plan) {
        if (plan instanceof BasicPlan) {
            return basicPolicy;
        } else {
            return premiumPolicy;
        }
    }
}
