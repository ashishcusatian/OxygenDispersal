package com.flipkart.oxygenDispersal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendorManager {
    private List<Vendor> vendors;
    private Map<Integer,Vendor> vendorMap;

    public VendorManager() {
        this.vendors = new ArrayList<Vendor>();
        this.vendorMap = new HashMap<Integer,Vendor>();
    }

    public  void registerVendor(String city, String state, float medicalOxygenCapacity, float industrialOxygenCapacity)
    {
        Vendor vendor=new Vendor(city, state, medicalOxygenCapacity, industrialOxygenCapacity);
        vendorMap.put(vendor.getVendorId(),vendor);
        vendors.add(vendor);
    }

    public void showAllVendors(String state)
    {
        for(Vendor vendor: vendors)
        {
            if(vendor.getState()==state)
            {
                System.out.println(vendor.getVendorId() +" city "+ vendor.getCity() + " MedicalOxygenCapacity " + vendor.getMedicalOxygenCapacity()
                + " IndustrialOxygenCapacity " + vendor.getIndustrialOxygenCapacity());
            }
        }
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Map<Integer, Vendor> getVendorMap() {
        return vendorMap;
    }

    public void setVendorMap(Map<Integer, Vendor> vendorMap) {
        this.vendorMap = vendorMap;
    }
}
