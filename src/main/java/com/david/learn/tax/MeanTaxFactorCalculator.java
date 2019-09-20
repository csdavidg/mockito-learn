package com.david.learn.tax;

import com.david.learn.interfaces.TaxService;
import com.david.learn.entities.Person;

public class MeanTaxFactorCalculator {

    private final TaxService taxService;

    public MeanTaxFactorCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateMeanTaxFactorFor(Person person) {
        double currentTaxFactor = taxService.getCurrentTaxFactorFor(person);
        double anotherTaxFactor = taxService.getCurrentTaxFactorFor(person);
        return (currentTaxFactor + anotherTaxFactor) / 2;
    }

    public String moneyCode(){
        return "COP";
    }

}
