package com.flipkart.oxygenDispersal;

import java.util.*;

public class ConsumerManager {
    Map<String,Consumer> consumerMap;
    List<Consumer> consumers;

    public ConsumerManager() {
        this.consumers = new ArrayList<Consumer>();
        this.consumerMap=new HashMap<String,Consumer>();
    }

    public Map<String, Consumer> getConsumerMap() {
        return consumerMap;
    }

    public void setConsumerMap(Map<String, Consumer> consumerMap) {
        this.consumerMap = consumerMap;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public void registerConsumer(String consumerId, String consumerType, String city, String state, float maxRequirement) throws Exception {
            ConsumerType actualConsumerType;
            Consumer consumer = null;
           if(consumerType=="Hospital") {
               actualConsumerType = ConsumerType.Hospital;
               consumer=new Hospital(consumerId,actualConsumerType,city,state,maxRequirement);
           }
           else if(consumerType=="Industry"){
               actualConsumerType=ConsumerType.Industry;
               consumer=new Industry(consumerId,actualConsumerType,city,state,maxRequirement);
           }
           else
           {
               throw new Exception("Invlaid Consumer type");
           }
           consumerMap.put(consumer.getConsumerId(),consumer);
           consumers.add(consumer);
    }
    class MaxRequirementComapartor implements Comparator<Consumer>
    {

        @Override
        public int compare(Consumer c1, Consumer c2) {
            if(c1.getMaxRequirement()==c2.getMaxRequirement())
            {
                return 0;
            }
            else if(c1.getMaxRequirement()>c2.getMaxRequirement())
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
    void showHospitals(String city)
    {
        Collections.sort(this.consumers,new MaxRequirementComapartor());
        for(Consumer consumer : consumers)
        {
            if(consumer instanceof Hospital && consumer.getCity()==city)
            {
                System.out.println(consumer.getConsumerId() + " " + (consumer.getMaxRequirement() - consumer.getOxygenUsed()) + " "+
                        consumer.getCity()+ " "+consumer.getState());
            }
        }
    }
    void showIndustry()
    {
        Collections.sort(this.consumers,new MaxRequirementComapartor());
        for(Consumer consumer : consumers)
        {
            if(consumer instanceof Industry)
            {
                System.out.println(consumer.getConsumerId() + " " + (consumer.getMaxRequirement()-consumer.getOxygenUsed()) + " "+
                        consumer.getCity()+ " "+consumer.getState());
            }
        }
    }
}
