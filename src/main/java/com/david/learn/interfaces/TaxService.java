package com.david.learn.interfaces;

import com.david.learn.pojos.Person;

public interface TaxService {

    double getCurrentTaxFactorFor(Person person);

    String getMoneyCode();
}
