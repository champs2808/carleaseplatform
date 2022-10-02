package com.CarLeaseProject.carleaseplatform.utilities;

public class CarLeaseUtility {

    /**
     *
     * @param mileage
     * @param duration
     * @param interestRate
     * @param nettPrice
     * @return
     */
    public static Double calculateCarLease(Double mileage,Integer duration, Float interestRate, Double nettPrice)
    {
        return Math.round(((((mileage/12)*duration)/nettPrice)+((interestRate/100)*nettPrice/12))*100.0)/100.0;
    }


}

