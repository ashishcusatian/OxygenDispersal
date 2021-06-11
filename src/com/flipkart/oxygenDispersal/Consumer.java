package com.flipkart.oxygenDispersal;

public abstract class  Consumer {
    private String consumerId;
    private ConsumerType consumerType;
    private String city;
    private String state;
    private float maxRequirement;
    private float oxygenUsed;

    public Consumer(String consumerId, ConsumerType consumerType, String city, String state, float maxRequirement) {
        this.consumerId = consumerId;
        this.consumerType = consumerType;
        this.city = city;
        this.state = state;
        this.maxRequirement = maxRequirement;
        this.oxygenUsed= 0.0F;
    }

    public float remainingOxygenLimit()
    {
        return (this.maxRequirement-this.oxygenUsed);
    }

    public float getOxygenUsed() {
        return oxygenUsed;
    }

    public void setOxygenUsed(float oxygenUsed) {
        this.oxygenUsed = oxygenUsed;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public ConsumerType getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(ConsumerType consumerType) {
        this.consumerType = consumerType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getMaxRequirement() {
        return maxRequirement;
    }

    public void setMaxRequirement(float maxRequirement) {
        this.maxRequirement = maxRequirement;
    }
}
