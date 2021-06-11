package com.flipkart.oxygenDispersal;

public class Vendor {
    private int vendorId;
    private String city;
    private String state;
    private float medicalOxygenCapacity;
    private float industrialOxygenCapacity;
    private boolean combineMultipleOfOxygen;

    public boolean isCombineMultipleOfOxygen() {
        return combineMultipleOfOxygen;
    }

    public void setCombineMultipleOfOxygen(boolean combineMultipleOfOxygen) {
        this.combineMultipleOfOxygen = combineMultipleOfOxygen;
    }

    public Vendor(String city, String state, float medicalOxygenCapacity, float industrialOxygenCapacity) {
        this.city = city;
        this.state = state;
        this.medicalOxygenCapacity = medicalOxygenCapacity;
        this.industrialOxygenCapacity = industrialOxygenCapacity;
        this.vendorId=IdGenerator.getId();
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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

    public float getMedicalOxygenCapacity() {
        return medicalOxygenCapacity;
    }

    public void setMedicalOxygenCapacity(float medicalOxygenCapacity) {
        this.medicalOxygenCapacity = medicalOxygenCapacity;
    }

    public float getIndustrialOxygenCapacity() {
        return industrialOxygenCapacity;
    }

    public void setIndustrialOxygenCapacity(float industrialOxygenCapacity) {
        this.industrialOxygenCapacity = industrialOxygenCapacity;
    }
}
