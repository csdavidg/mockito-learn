package com.david.learn.interfaces;

import com.david.learn.entities.Person;

public interface TaxService {

    double getCurrentTaxFactorFor(Person person);

    String getMoneyCode();
}
