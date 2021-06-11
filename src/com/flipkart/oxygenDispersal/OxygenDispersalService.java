package com.flipkart.oxygenDispersal;

import java.util.Map;

public class OxygenDispersalService {
    ConsumerManager consumerManager;
    VendorManager vendorManager;

    public OxygenDispersalService() {
        this.consumerManager = new ConsumerManager();
        this.vendorManager =new  VendorManager();
    }

    public  void registerConsumer(String consumerId, String consumerType, String city, String state, float maxRequirement) throws Exception {
        consumerManager.registerConsumer(consumerId, consumerType, city, state, maxRequirement);
    }
    public void registerVendor(String city, String state, float medicalOxygenCapacity, float industrialOxygenCapacity){
        vendorManager.registerVendor(city, state, medicalOxygenCapacity, industrialOxygenCapacity);
    }
    public void showHospitals(String city)
    {
        consumerManager.showHospitals(city);
    }
    public void showIndustry()
    {
        consumerManager.showIndustry();
    }
    public void showVendors(String state)
    {
        vendorManager.showAllVendors(state);
    }
    public boolean bookOxygen(String consumerId, float amount)
    {
        Map<String , Consumer> consumerMap=consumerManager.getConsumerMap();
        Consumer consumer=consumerMap.get(consumerId);
        ConsumerType consumerType=consumer.getConsumerType();
        if(amount<0)
            return false;

        if(amount+consumer.getOxygenUsed()>consumer.getMaxRequirement())
        {
            return false;
        }
        boolean found = false;
        if(consumerType==ConsumerType.Hospital)
        {

            for(Vendor vendor: vendorManager.getVendors())
            {
                if(vendor.getMedicalOxygenCapacity()>=amount)
                {
                    vendor.setMedicalOxygenCapacity(vendor.getIndustrialOxygenCapacity()-amount);
                    found=true;
                    consumer.setOxygenUsed(consumer.getOxygenUsed()+amount);
                    System.out.println("Medical oxygen purchased successfully from " +vendor.getCity() + " Vendor, "+ consumer.getConsumerId() +" can order more "+ consumer.remainingOxygenLimit() +"L oxygen");

                    break;
                }
            }
            if(!found)
            {
                for(Vendor vendor: vendorManager.getVendors())
                {
                    if((vendor.getMedicalOxygenCapacity()+ vendor.getIndustrialOxygenCapacity())>=amount)
                    {
                        consumer.setOxygenUsed(amount+consumer.getOxygenUsed());
                        amount-=vendor.getMedicalOxygenCapacity();
                        vendor.setMedicalOxygenCapacity(0);
                        if(amount>0.0)
                        vendor.setIndustrialOxygenCapacity(vendor.getIndustrialOxygenCapacity()-amount);
                        System.out.println("Medical oxygen purchased successfully from " +vendor.getCity() + " Vendor, "+ consumer.getConsumerId() +" can order more "+ consumer.remainingOxygenLimit() +"L oxygen");
                                found=true;
                        break;
                    }
                }
            }


        }
        if(consumerType==ConsumerType.Industry)
        {

            for(Vendor vendor: vendorManager.getVendors())
            {
                if(vendor.getIndustrialOxygenCapacity()>=amount)
                {
                    consumer.setOxygenUsed(consumer.getOxygenUsed()+amount);
                    vendor.setIndustrialOxygenCapacity(vendor.getIndustrialOxygenCapacity()-amount);
                    found=true;
                    System.out.println("Industrial oxygen purchased successfully from " +vendor.getCity() + " Vendor, "+ consumer.getConsumerId() +" can order more "+ consumer.remainingOxygenLimit() +"L oxygen");
                    break;
                }
            }

        }


        return found;


    }

}
