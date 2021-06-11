package com.flipkart.oxygenDispersal;

public class Main {

    public static void main(String[] args) throws Exception {

        OxygenDispersalService oxygenDispersalService=new OxygenDispersalService();

        oxygenDispersalService.registerVendor("Bengaluru", "Karnataka", 100, 100);
        oxygenDispersalService.registerVendor("Mysuru", "Karnataka", 50, 100);
        oxygenDispersalService.registerConsumer("H1", "Hospital", "Bengaluru", "Karnataka", 150);
        oxygenDispersalService.registerConsumer("H2", "Hospital", "Bengaluru", "Karnataka", 150);
        oxygenDispersalService.registerConsumer("I1", "Industry", "Bengaluru", "Karnataka", 150);

        oxygenDispersalService.bookOxygen("H1", 120);

        oxygenDispersalService.bookOxygen("I1", 100);

        oxygenDispersalService.showVendors("Karnataka");
        oxygenDispersalService.showHospitals("Bengaluru");
        oxygenDispersalService.showIndustry();

    }
}
